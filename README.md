# algorithm-demo

利用 idea 插件 leetcode editor 练习算法

## 模板

**勾选 custom template**

code file name

```
P${question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug})
```

codeTemplate

```
${question.content}
package leetcode.editor.cn;
//java:${question.title}
public class P${question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug}){
    public static void main(String[] args){
        Solution solution = new P${question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
    }
    ${question.code}
}
```