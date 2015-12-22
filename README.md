# LighterDemo 说明文档
记录Android中一些知识点以及库的使用文档，帮助知识的理解。

## 使用库
+ [LeakCanary](https://github.com/square/leakcanary)
+ [Logger](https://github.com/orhanobut/logger)

## 内存泄露（Leak包下面）
+ TreadActivity 耗时匿名内部类，持有Activity的引用，不能被回收，导致内存泄露
+ WeakCallActivity: 弱引用回调，持有外部类，当GC的时候，会被回收，一定程度上，缓解了内存泄露的问题。
+ StaticReferenceActivity Activity被静态变量持有，导致不能被释放
+ HandlerActivity Handler的错误使用姿势，导致的内存泄露


