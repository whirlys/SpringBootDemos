## 探秘spring AOP

简介：面向切面编程（AOP）提供另外一种角度来思考程序结构，通过这种方式弥补了面向对象编程（OOP）的不足。同时AOP框架也是Spring的一个关键的组件在平时的面试中也是一个容易被询问到的知识点

> 课程地址：http://www.imooc.com/learn/869


----


### **概览**

**编程范式概览**

> 编程范式的内容很多，网易公开课上有一门斯坦福的《编程范式》课程
http://open.163.com/special/opencourse/paradigms.html

1. 面向过程编程
2. 面向对象编程
3. 函数式编程
4. 事件驱动编程
5. 面向切面编程

**AOP是什么？**

1. 是一种编程范式，不是编程语言
2. 解决特定问题，不能解决所有问题
3. 是OOP的补充，不是替代

**AOP的初衷**

![](assets/markdown-img-paste-20171007153456726.png)


**AOP的好处**

1. 集中处理某一关注点/横向逻辑
2. 可以很方便地添加/删除关注点
3. 侵入性少，增强代码可读性和可维护性

**应用场景**

![](assets/markdown-img-paste-20171007154225637.png)

---

### **AOP使用**

**案例背景**

1. 产品管理的服务
2. 产品添加/删除的操作只能管理员才能进行
3. 普通实现VSAOP实现

![](assets/markdown-img-paste-2017100715440941.png)

**使用方式**

![](assets/markdown-img-paste-20171007154433318.png)

![](assets/markdown-img-paste-20171007154500925.png)

![](assets/markdown-img-paste-20171007154508230.png)

![](assets/markdown-img-paste-20171007154514720.png)

![](assets/markdown-img-paste-20171007154532945.png)

![](assets/markdown-img-paste-20171007154544107.png)

![](assets/markdown-img-paste-20171007154548745.png)

![](assets/markdown-img-paste-20171007154554126.png)

![](assets/markdown-img-paste-20171007154558955.png)

![](assets/markdown-img-paste-20171007154602899.png)

![](assets/markdown-img-paste-20171007154606872.png)

![](assets/markdown-img-paste-20171007154611114.png)

![](assets/markdown-img-paste-20171007154615911.png)

![](assets/markdown-img-paste-20171007154619351.png)

![](assets/markdown-img-paste-20171007154624907.png)

![](assets/markdown-img-paste-2017100715463113.png)

![](assets/markdown-img-paste-20171007154800136.png)

----

### **AOP原理**

![](assets/markdown-img-paste-20171007154810920.png)

![](assets/markdown-img-paste-20171007154826229.png)

![](assets/markdown-img-paste-20171007154835643.png)

![](assets/markdown-img-paste-20171007154841977.png)


---

### **课程实战**

### **总结**
