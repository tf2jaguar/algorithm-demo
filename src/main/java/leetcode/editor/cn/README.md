# 来源


利用 idea 插件 `leetcode editor` 练习算法

## 模板

tempFilePath

```
/Users/zhangguodong/Documents/idea/my-github/algorithm-demo/src/main/java
```

**勾选 custom template**

code file name

```
Q${question.frontendQuestionId}_$!velocityTool.camelCaseName(${question.titleSlug})
```

codeTemplate

```
${question.content}
package leetcode.editor.cn;

/**
 * title: ${question.frontendQuestionId} : ${question.title}
 * create: $!velocityTool.date()
 */
public class Q${question.frontendQuestionId}_$!velocityTool.camelCaseName(${question.titleSlug}){
    public static void main(String[] args){
        Solution solution = new Q${question.frontendQuestionId}_$!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
    }
    ${question.code}
}
```