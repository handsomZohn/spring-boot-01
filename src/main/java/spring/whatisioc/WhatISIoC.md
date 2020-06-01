## 什么是IoC的实现机制
### Fruit 接口，有 Apple 和 Orange 两个实现类。
### Factory 工厂，通过反射机制，创建 className 对应的 Fruit 对象。
### Client 通过 Factory 工厂，获得对应的 Fruit 对象。
### 😈 实际情况下，Spring IoC 比这个复杂很多很多，例如单例 Bean 对象，Bean 的属性注入，相互依赖的 Bean 的处理，以及等等。