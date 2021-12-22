# 加权轮询算法(wrr)

参考[https://mp.weixin.qq.com/s/P25wnGkOjrZiq034UIu2pg](https://mp.weixin.qq.com/s/P25wnGkOjrZiq034UIu2pg)

## 随机数版本

最简单的方式，就是使用随机数去实现。当然，只有在请求量比较大的情况下，随机分布才会向7、2、1的比例逼近。这通常都没什么问题，比如SpringCloud的Robion组件，就是使用随机轮询的方式。

我们首先计算总的权重值，记作total，然后每次调用都取total区间的随机数，再依次遍历所有的权重数据。

next方法的时间复杂度，在最坏的情况下是O(n)。

随机调度获取的调用顺序也是随机的，对类似于微服务节点轮询这种场景，比较友好。但对于一些调用量比较小的服务，可能有些节点就会被饿死，毕竟是随机数嘛。

```java
public class WrrRnd implements IWrr {
final int total;
final Element[] elements;
final Random random = new SecureRandom();

    public WrrRnd(Element[] elements) {
        this.total = Arrays.stream(elements)
                .mapToInt(ele -> ele.weight)
                .sum();

        this.elements = elements;
    }

    @Override
    public String next() {
        final int n = elements.length;
        int index = n - 1;
        int hit = random.nextInt(total);

        for(int i = 0; i < n; i++){
            if(hit >= 0) {
                hit -= elements[i].weight;
            }else{
                index = i - 1;
                break;
            }
        }

        return elements[index].peer;
    }
}
```
## 递增版本

## Nginx 方式

nginx这个版本就更上一层楼，可以达到A,A,B,A,A,C,A,A,B,A,的效果。在保证准确的权重前提下，实现了调用尽量的分散。

这个算法比较巧妙，可以说是非常天才的算法。如果你没有接触过的话，是绝对写不出来的。

虽然算法比较简单，但要证明算法的准确性却不是一件容易的事情。证明的具体过程可以参考以下链接。

> https://tenfy.cn/2018/11/12/smooth-weighted-round-robin/

看我们的代码，封装了一个叫做Wrr的类。这个类在原来权重的基础上，增加了一个当前的权重值current。current没次调用都会改变。

在每一轮调用中，都会在current上加上对应节点的weight值，然后选择current值最大的那一个，当作本轮的调度节点。

被选中的节点，将会减去所有的权重值total，然后进行下一次调度。唯一的问题是，当节点比较多的时候，它的时间复杂度总是O(n)，执行效率上要打一些折扣。

```java
public class WrrSmooth implements IWrr {
    class Wrr {
        Element ele;
        int current = 0;

        Wrr(Element ele) {
            this.ele = ele;
        }
    }

    final Wrr[] cachedWeights;

    public WrrSmooth(Element[] elements) {
        this.cachedWeights = Arrays.stream(elements)
                .map(Wrr::new)
                .collect(Collectors.toList())
                .toArray(new Wrr[0]);
    }

    @Override
    public String next() {
        int total = 0;
        Wrr shed = cachedWeights[0];

        for (Wrr item : cachedWeights) {
            int weight = item.ele.weight;
            total += weight;

            item.current += weight;
            if (item.current > shed.current) {
                shed = item;
            }
        }
        shed.current -= total;
        return shed.ele.peer;
    }
}
```

Nginx的这个版本，写法非常简单。建议好好理解，掌握红黑树和Ningx版本的写法即可。