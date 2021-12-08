# SSMDemo
SSM样例代码和知识点
Processon思维导图链接地址：https://www.processon.com/mindmap/61643651e401fd3c24907e83
---------------------------------------------------------------------------------------------------------------------------------------------------------------
【Spring01-IOC】
----【demo1_introduction】
         【控制就是获得实例的过程】UserService、UserServiceImpl、
             以前我们通过new来获取一个实例对象，现在可以使用Spring容器来获取实例对象。
             注意Junit的使用。pom.xml中scope范围对应test。 //@Test注解
----【demo2_ioc1】
         【准备】
             【导包spring-context】
                 spring-context包括spring-expression、spring-core（包括spring-jcl）、spring-aop、spring-beans
                 Maven中的小板凳标志可以可视化的看到包之间的依赖关系。
                 IDEA默认的Maven不是阿里的，外网下载比较慢，可以在setting->Maven中查看更改Maven的路径、版本、配置、仓库。
             【业务代码】UserService、UserServiceImpl
             【Spring官网配置文件】
                 链接地址：https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#xsd-schemas-context
                 可以复制该内容，并编辑一个文件模板，以备后用。
             【resource中创建application.xml】
                 使用刚刚生成的文件模板。
             【使用反射获取实例对象】IOCTest.test1()
                 Spring就是基于反射获取类的实例的。
                 Class.forName()、aClass.newInstance()
         【使用Spring】
             【在application.xml中注册组件】
                 <com.bean>标签、id属性、class属性
             【方式1---组件id】IOCTest.test2()
                 spring容器提供了应用上下文applicationContext，通过应用上下文可以获得组件。
                     需要加载spring配置文件 -> 直接写resources（classpath）下的配置文件名。
                     new ClassPathXmlApplicationContext("application.xml");
                 获取实例对象：applicationContext.getBean("userService")  //getBean()中的字符串参数是，要获取的对象所属的组件的id。
             【方式2---类的类型class】IOCTest.test3()
                 加载应用上下文同方式1。
                 获取实例对象：applicationContext.getBean(UserServiceImpl.class); //通过要加载的类的类型来获取实例对象。
             【方式1和方式2的比较】
                 同一个类型的组件不唯一（也就是在application.xml中用不同的id注册了两次），则方式1不会报异常，而方式2会报异常。
----【demo3_ioc2】
         【业务代码】User、UserDao、UserDaoImpl、UserService、UserServiceImpl
              //lombok的使用
              //application.xml中，bean标签的property子标签的name属性和ref属性。
                注意，这里name属性的值和bean标签对应的类的set方法的方法名是必须对应的，
                比如说，UserService中包含成员变量UserDao，
                      如果UserService中的set方法名是setUserDaoz()，则spring配置文件中UserService对应的bean标签的子标签（对应UserDao）的name值应该是userDaoz。
                      如果UserService采用了@Data注解（默认为setUserDao()），则name值应该为userDao。
         【使用se的形式】IOCTest.test1()
         【使用spring的形式】IOCTest.test2()【这块有点乱】
         【比较】
             [1]直接通过spring容器获取UserDao；
             [2]先通过spring容器获取UserService，在通过UserService的getUserDao()获取UserDao；
             [3] [1][2]两种方式获取到的UserDao是同一个。
         【ClassPathXmlApplicationContext和FileSystemXmlApplicationContext】ApplicationContextTest
             [1]ClassPathXmlApplicationContext
                   classpath：resources（或java）下的文件名
                   new ClassPathXmlApplicationContext("application.xml")
             [2]FileSystemXmlApplicationContext
                   文件系统：文件的全名
                   new FileSystemXmlApplicationContext(configPath);//configPath是application.xml的绝对路径。
             [3]ClassPathXmlApplicationContext和FileSystemXmlApplicationContext的比较
                   两者获取到的bean不是同一个，因为上下文就不是同一个。
             //Ctr+H查找键，向上查找、向下查找。
----【demo4_scope】
         【bean的作用域】
             //默认情况下：true          //获得的是同一个bean
             //scope=singleton  true   //获得的是同一个bean
             //scope=prototype  false  //获得的不是同一个bean
         【singleton，但是上下文不同】
             获取的不是同一个bean，因为spring容器上下文不同。
----【demo5_regist】NoArgsConstructorBean、AllArgsConstructorBean、application.xml、registTest
         【组件注册---无参构造】
             <com.bean>标签的子标签<property>的name属性（和bean的成员变量一致）、value属性（注意和ref属性的区别）
         【组件注册---有参构造】
             <com.bean>标签的子标签<constructor-arg>的name属性（和有参构造方法的参数一致，而非和成员变量一致）、value属性。
             重要：name属性的值和有参构造方法的参数一致，而非和成员变量一致。
                  采用lombok的@AllArgsConstructor注解，则显然和成员变量一致，
                  否则，一定要注意有参构造函数的形参名！（如示例中的usernameA和passwordA）
         //lombok的@NoArgsConstructor注解、@AllArgsConstructor注解
----【demo6_factory】
          //静态工厂：在静态工厂类的静态方法中return一个新创建的bean对象。
            实例工厂：在实例工厂类的非静态方法中return一个新创建的bean对象。
         【se的形式】
             //静态工厂：不需要实例化静态工厂，就可以创建一个bean对象。
               实例工厂：需要实例化实例工厂，才可以用实例工厂对象创建一个bean对象。
         【Spring的形式】
             //主要关注spring的配置文件application.xml的区别
             //静态工厂：
                 [1]直接获取bean对象
                    bean标签（bean对象）：id、class（指向静态工厂）、factory-method（静态工厂中创建bean对象的静态方法的方法名）
             //实例工厂：
                 [1]实例工厂要先实例化
                    bean标签（实例工厂对象）：id、class（指向实例工厂）
                 [2]然后在通过实例工厂的实例对象来获取bean对象
                    bean标签（bean对象）：id、factory-bean（实例工厂对象的id）、factory-method（实例工厂中创建bean对象的非静态方法的方法名）
----【demo7_lifecycle】
         【疑问】这一块还是比较迷
         //bean标签中的init-method属性、destroy-method属性。
---------------------------------------------------------------------------------------------------------------------------------------------------------------
【Spring02-AOP】
----【demo1-collection】
         //创建一个集合Bean，在类中创建各种集合类型的成员变量。  //CollectionBean
         //成员变量的类型有array、list、set、map、properties
         //包含这些类型的成员变量的bean怎么在spring配置文件中进行注册，是这个模块要解决的问题。
         【起步】
             首先，bean对象的成员变量在组件注册时，都需要一个<property>子标签。<property>标签的name属性值为成员变量名。
         【Array】
             <property> -> <array> -> <value> //<value>标签中写具体的值。
         【List】
             <property> -> <list> -> <value> //<value>标签中写具体的值。
         【Set】
             <property> -> <set> -> <value> //<value>标签中写具体的值。
         【Map】
             <property> -> <map> -> <entry> //<entry>标签的key属性、value属性中写入具体的key、value值。
         【Properties】
             <property> -> <props> -> <prop> //<prop>标签的key属性写入具体的key值，<prop>标签中写入具体的value值。
             //注意区分Map和Properties的value值写入的位置。
         【bean对象的成员变量是集合类型，并且集合的元素类型不是基本类型的包装类】
             //这里举一个User类的例子
             【起步】<property> -> <array>、<list>、<set>、<map>这部分都是一样的。
                   和之前不同的是值不再是简单的写在<value>标签中，因为现在的值是bean对象，要按照<bean>注册的形式写。
                   bean对象有国产和进口两种方式。
                   <array>、<list>、<set>最简单。
                      国产：<bean>标签&class属性（id属性不需要） -> <property>子标签&name属性&value属性。
                      进口：<ref>标签&bean属性（指向要引用的已经注册的bean的id）。
                   <map>稍有不同。
                      国产：<entry>标签&key属性 -> <bean>标签&class属性（id属性不需要） -> <property>子标签&name属性&value属性。
                      进口1：<entry>标签&key属性&value-ref属性（指向要引用的已经注册的bean的id）
                      进口2：<entry>标签&key属性 -> <ref>子标签&&bean属性（指向要引用的已经注册的bean的id）。
----【demo2-annotation】
          //spring配置文件中，<context:component-scan base-package="com.bupt"/>
            <context:component-scan>标签：打开注解扫描开关。
                base-package属性：扫描base-package属性值对应的包及其全部子包。
         【之前的方式】
             组件注册都是在application.xml中注册的。
             //在application.xml中注册 userService -> UserServiceImpl
         【注解】
              【@Component注解】
                  此时注释掉配置文件中userService的注册。UserServiceImpl类上加上@Component注解。
                  测试出错：原因UserServiceImpl类加上@Component注解，默认是以userServiceImpl为组件id的。//以类名首字母小写作为组件id。
                  解决：@Component("userService") //@Component注解带id参数，指定注册的组件的id。
              【组件注册相关】
                  //@Repository、@Service、@Controller注解
                  //特定的类上去使用的组件注册注解。
                    @Repository -> dao的实现类
                    @Service -> service的实现类
                    @Controller -> SpringMVC控制层的类上（后面会使用到）
                  //不带id参数的@Service注解和不带id参数的@Component注解效果相同。
                  【疑问】如果UserServiceImpl加上不带id参数的@Service注解，
                            并以getBean("userService")的形式获取bean，则会报错。//@Service注解需要指定id为userService
                            而以getBean(UserService.class)的形式获取bean，则运行正常。
              【组件注入相关】
                  【@Autowired】
                      //UserServiceImpl类中添加了UserDao成员变量。
                        使用XML配置注册userService时，需要一个<property>子标签，id值为userDao，并且需要UserServiceImpl类提供对应的set方法（可以直接用@Data注解）。
                        此时，我们使用@Service注解，会报空指针异常，因为此时的userDao为null。
                      //这个时候我们全部采用注解的方式。
                        UserServiceImpl -> @Service、UserDaoImpl -> @Repository
                        然后，最关键的，在UserServiceImpl类的成员变量userDao前面加上@Autowired注解，注入容器中已经注册的UserDaoImpl。
                        也就是说：采用注解注入的方式甚至不需要提供set方法。
                  【@Qualifier】
                      //如果容器中这个类型的组件只有一个，则可以直接使用@Autowired
                        如果容器中这个类型的组件不止一个，则需要加上@Qualifier，并指定组件的id。//@Qualifier必须搭配@Autowired使用。
                  【@Resource】
                      //只写@Resource相当于@Autowired，如果这个类型的组件不止一个，则需要使用name属性指定id。
                  【三者总结】
                      @Autowired -> 不能指定组件的id，只适用于同类型的组件只有一个的情况。
                      @Qualifier -> 搭配@Autowired使用，可以指定组件的id，解决了@Autowired不适用于同类型的组件只有一个的情况的问题。
                      @Resource -> 可以不指定组件的id，也可以指定组件的id。//和@Qualifier不同，它不需要和@Autowired搭配使用。
                  【@Value】
                      //给值属性的成员变量注入值。
                      //比如userDao、userInfo、maxSize都是UserServiceImpl类的成员变量，
                        userDao需要作为组件注入，而userInfo、maxSize只是普通的变量，而在这些变量前加上@Value注解，可以给这些变量注入值。
                        例如，@Value("czgbyer666")、@Value("10")
                      //@Value还可以从properties中取key和value。
                        首先，需要在application.xml中加载这个properties文件。
                        <context:property-placeholder location="classpath:user.properties"/>
                        然后可以直接使用@Value("${user.userInfo}")、@Value("${user.maxSize}")加载key-value。
                      //引进的properties配置文件的值除了在@Value中使用，在spring配置文件中也可以使用。//让bean标签的value值为${}。
              【作用域相关】
                  【@Scope】
                       @Scope -> 默认单例
                       @Scope("singleton") -> 单例
                       @Scope("prototype") -> 原型
              【生命周期】
                  【spring配置文件的形式】
                      <bean>标签的 id属性 & class属性 & init-method属性 & destroy-method属性。
                      init-method属性 和 destroy-method属性 的值指定为自定义的init、destroy方法。
                  【注解的形式】
                      //@PostConstruct、@PreDestroy
                      注释掉<bean>标签的内容，LifeCycleBean的前面加上@Component注解。此时init、destroy方法失效。
                      在自定义的init、destroy方法上分别加上@PostConstruct、@PreDestroy注解，则init、destroy方法再次生效。
                  【单元测试类】【有点迷】
                      pom.xml中加入spring-test包。
                      在测试类中，如果直接注入UserService组件，并调用其sayHi方法，会报空指针异常。
                      要先在测试类上加上@RunWith(SpringJUnit4ClassRunner.class)、@ContextConfiguration("classpath:application.xml")，才能生效。【有点迷】
----【demo3-dynamic_proxy】
         //AOP---手动实现
         【AOP基础概念】
             AOP：面向切面编程。 //把需要增强的方法放到一起，做一个统一的调用。
             target（目标类）-> proxy（代理类）
             joinpoint（连接点）：过程中的某个点
             pointcut（切入点）：划分增强范围，指定哪些方法被增强。//谁（哪个方法）
             advice（通知）：在什么时间，做什么事情。
             weaver（织入）：动作，由目标类对象生成代理类对象的动作。
             Aspect（切面）：切面=切入点+通知 //谁，在什么时间，做什么事情
         【AOP的底层】
             采用动态代理增强。
             如果有接口的实现，采用jdk动态代理。
             如果没有接口的实现，采用cglib动态代理。
         【AOP实战---手动采用动态代理---jdk动态代理】
             [1]创建target对象userService
             [2]创建proxy对象userServiceProxy
                 Proxy.newInstance()
                     //包含3个参数：
                         1.userService.getClass().getClassLoader()
                         2.userService.getClass().getInterfaces()
                         3.new InvocationHandler()
                             //这是创建一个匿名内部类对象
                             //主要逻辑在于重写匿名内部类InvocationHandler的invoke方法
                                 //invoke方法的3个参数：Object proxy, Method method, Object[] args
                                   Object invoke = method.invoke(userService, args);
                                   在这条赋值语句的前后写增强的语句。
                                   return invoke
             [3]proxy对象userServiceProxy调用原来的方法（已经被增强）。
         【AOP实战---手动采用动态代理---cglib动态代理】
             【注意】
                 //使用cglib动态代理需要导spring-context包。
             [1]创建target对象userService
             [2]创建proxy对象userServiceProxy
                 Enhancer.create()
                     //包含2个参数：
                         1.UserService.class
                         2.new InvocationHandler()
                             //这是创建一个匿名内部类对象  //查看源码可以发现这里的InvocationHandler接口和jdk动态代理里面的不是同一个。
                             //主要逻辑在于重写匿名内部类InvocationHandler的invoke方法
                                 //invoke方法的3个参数：Object o, Method method, Object[] objects
                                 Object invoke = method.invoke(userService, objects);
                                 在这条赋值语句的前后写增强的语句。
                                 return invoke
             [3]proxy对象userServiceProxy调用原来的方法（已经被增强）。
----【demo4-spring_aop】
         //AOP---采用spring aop的形式实现
         【业务代码】UserService、UserServiceImpl
         //首先，打开注解扫描开关，<context:component-scan>标签。
         【自定义advice通知】CustomAdvice
             //加上@Component注解
             实现MethodInterceptor接口。//方法拦截器
                 重写invoke()方法：
                     方法参数：MethodInvocation methodInvocation
                     Object proceed = methodInvocation.proceed();
                     在这条赋值语句的前后写增强的语句。
                     return proceed;
         【注册一个代理对象组件】【有点迷惑】application.xml
             //id属性值为：userServiceProxy
             //class属性值为：org.springframework.aop.framework.ProxyFactoryBean
             //userServiceProxy有两个成员：
                 [1]target//目标类
                     ref属性值为：userServiceImpl
                 [2]interceptorNames//拦截器名字，即，通过哪个advice增强的。
                     value值为customAdvice  //这个参数是字符串类型，写的是value属性，而非ref属性。
         【测试】SpringAOPTest
             //pom.xml中要导入spring-test包。
               要先在测试类上加上@RunWith(SpringJUnit4ClassRunner.class)、@ContextConfiguration("classpath:application.xml")，才能生效。【疑问】
             //[1]@Autowired  //直接注入UserService组件，并调用其sayHi方法，会报空指针异常。
             //[2]@Resource(name = "userServiceImpl")  //AOP未生效
             //[3]@Resource(name = "userServiceProxy") //AOP生效
----【demo5-advisor】
        //demo4-spring_aop中的代理对象是在application.xml中手动注册生成的，目前只有一个代理对象。
          如果需要100个代理对象呢？手动生成会非常麻烦。
        【准备工作】
             [1]pom.xml中导入aspectjweaver这个包
             [2]application.xml中在Spring官网配置文件01的基础上，引入aop的schema。
                  <beans>标签中增加xmlns:aop属性，其属性值为http://www.springframework.org/schema/aop
                  <beans>标签的xsi:schemaLocation属性值中，加入http://www.springframework.org/schema/aop https://www.springframework.org/schema/aop/spring-aop.xsd
        【Pointcut切入点表达式】
             作用：划分方法（直接指定某一些方法）
             表达式：execution(修饰符，返回值，包名.类名.方法名(参数))
                 修饰符：可以省略，省略代表任意的修饰符。
                 返回值：不可以省略，可以使用*来进行通配。
                     //返回值的写法：如果是基本类型或者是java.lang包目录下的，可以直接写。
                                   如果不在这个范围，需要写全类名。
                 包名.类名.方法名：首尾不能省略，中间部分可以省略，使用..进行省略。
                                 可以使用*通配，*可以代表一个单词或者一个单词的一部分。
                 参数：可以省略不写，省略不写代表的是无参函数。
                      *通配一个参数，..代表任意参数（任意数量任意类型的参数）。
                      和返回值相同，如果是基本类型或者是java.lang包目录下的，可以直接写。
                                  如果不在这个范围，需要写全类名。
        【业务代码】User、UserService、UserServiceImpl
                  CustomAdvice //实现MethodInterceptor接口 //@Component
                  AdvisorTest
             //此处AdvisorTest使用@Autowired注解注入UserService对象不会报空指针异常【有点迷惑，同上】
        【application.xml的配置】
             <aop:config>标签 -> <aop:advisor>子标签 -> advice-ref属性 & pointcut属性
             advice-ref属性的值是advice组件的id。
             pointcut属性值为切入点表达式。
                 demo5的例子：
                     完整的切入点表达式：execution(public void com.bupt.service.UserServiceImpl.sayHello(String))
                     修饰符省略，返回值通配，包名.类名.方法名部分省略首尾通配，参数不省略：execution(* *.bu*..*(String))
                         //注意：这里参数不要省略，省略就代表无参了，aop会不生效
---------------------------------------------------------------------------------------------------------------------------------------------------------------
【Spring03-Aspect】
----【demo1-aspectj】
        【导包】spring-context、spring-test、junit、lombok、aspectjweaver
        【业务代码】UserService、UserServiceImpl
        【定义切面类】CustomAspect
            //@Component
            //切面类中的方法（通知方法）：就是做什么事情。//mybefore()、myafter()
              时间：由我们来决定。 //在application.xml中将切面类的方法和aop的before、after等关联起来。
        【application.xml中进一步配置】
            <aop:config>标签
                -> <aop:aspect>标签
                        //ref属性（指向自定义的切面类的id）
                    -> <aop:pointcut>标签
                        //id属性 & expression属性
                    -> <aop:before>标签
                        //method属性（自定义切面类中对应的方法名）
                        //pointcut-ref属性（指向pointcut的id）
                    -> <aop:after>标签
                    -> <aop:after-throwing>标签
                    -> <aop:after-returning>标签
                    -> <aop:around>标签
        【测试】AspectjTest
            此时测试类中的UserService对象已经是一个代理对象了。
        【在通知方法中可以增加JoinPoint类的形参】
            Signature getSignature();  //获取封装了方法签名的对象，通过Signature可以进一步获取方法名等信息。
            Object[] args;  //获取传入目标方法的参数对象
            Object getTarget();  //获取被代理对象
            Object getThis();  //获取代理对象
        【doAround】
            <aop:around>标签
            CustomAdvice中的myaround()方法。
                增加一个ProceedingJoinPoint类的形参。还包括一个Object类型的返回值。
                之后的操作类似手动代理中的方法增强：
                    Object proceed = proceedingJoinPoint.proceed();
                    在这条赋值语句的前后写增强的语句。
                    return proceed;
        【after-returning】
            <aop:after-returning>标签  //注意多了一个returning属性，属性值为”object”。
            CustomAdvice中的myafterReturning()方法。
                增加一个Object类型的形参。
                可以在方法中输出object。//如果切入点方法没有返回值，则object的值为null；
                                       如果切入点方法有返回值，则object的值为这个返回值的值。
        【after-throwing】
            <aop:after-throwing>标签  //注意多了一个throwing属性，属性值为”throwable”。
            CustomAdvice中的myafterThrowing()方法。
                增加了一个Throwable类型的形参。
                可以在方法中输出throwable。//如果切入点方法没有抛出异常，则throwable的值为null；
                                          如果切入点方法有抛出异常，则throwable的值为这个异常的异常信息。//例如，除零异常：java.lang.ArithmeticException: / by zero
        【补充&总结】
            通知方法均可以增加JoinPoint形参。
            around的返回值是Object，形参是ProceedingJoinPoint。
            after-returning、after-throwing都有特殊类型的形参。
            <aop:pointcut>标签可以写在<aop:aspect>标签里面，也可以写在外面。
----【demo2-aspect_annotation】
        //通过注解来使用aspectj，不再使用<aop:config>标签。
        【准备】复制deno1种的业务代码、切面类、测试类、pom.xml
        【注解方式】
            [1]application.xml中增加<aop:aspectj-autoproxy>标签，打开注解开关。
            [2]切面类上增加@Aspect注解，标记为切面类。
               //这样就不需要在配置文件中使用<aop:aspect>来注册切面类了。
               //注意：@Component和@Aspect注解缺一不可。
            [3]在通知方法上增加对应的注解。  //这样就不需要在配置文件中使用对应的通知方法、pointcut的标签。
               //第一种方式（在通知方法注解中，直接写入切入点表达式）：
                     @Before("execution(...)")
                     @After("execution(...)")
                     @Around("execution(...)")
                     @AfterReturning(value="execution(...)",returning="object")
                     @AfterThrowing(value="execution(...)",throwing="throwable")
               //第二种方式（先注册切入点表达式组件，再在通知方法中引用切入点表达式）
                     @Pointcut("execution(...)")
                     public void mypointcut(){}
                     @Before("mypointcut()")
                     @After("mypointcut()")
                     @Around("mypointcut()")
                     @AfterReturning(value="mypointcut()",returning="object")
                     @AfterThrowing(value="mypointcut()",throwing="throwable")
----【demo3-aspectj_annotation】
         //使用自定义注解来使用pointcut
        【导包】spring-context、spring-test、junit、lombok、aspectjweaver
        【application.xml】
            打开注解开关：<context:component-scan base-package="com.bupt"/>
                        <aop:aspectj-autoproxy/>
        【业务代码】UserService、UserServiceImpl
            //sayHello()方法中增加一条语句：Thread.sleep(5000)
        【自定义注解CountTime】
            //@interface
            //@Retention(RetentionPolicy.RUNTIME)  //这个自定义注解在程序运行时生效
              @Target(ElementType.METHOD)          //这个自定义注解加在方法上
        【编写切面类CustomAspect】
            //@Component、@Aspect
            //@Pointcut注解中不再写切入点表达式，而是自定义注解。//注解出现在哪里，哪里就被增强。
                  @Pointcut("annotation(com.bupt.anno.CountTime)")
                  public void mypointcut()
            //Aspect的通知方法这里也使用注解的方式，同demo2。
                  业务逻辑：使用around方法计算切入点方法的执行时间。
        【将自定义注解加在需要增强的方法上】
            //此处将@CountTime注解加在UserServiceImpl类的sayHello()方法上，sayHi()方法不加（作为对比）。
        【测试类】AspectjAnnotationTest
            @RunWith(SpringJUnit4ClassRunner.class)
            @ContextConfiguration("classpath:application.xml")
---------------------------------------------------------------------------------------------------------------------------------------------------------------
【Spring04-Tx】
----【demo1-jdbc_template】
        【导包】spring-jdbc、mysql-connect-java、druid、junit //先不导入spring-context、spring-test
               注意mysql驱动mysql-connect-java的版本要和电脑上安装的mysql的版本一致。比如mysql版本8.0.26，驱动的版本是8.0.11
        【se的形式】SeTest
            [1]提供一个数据源new DruidDataSource()
            [2]数据源的4个配置：driverClassName、url、username、password
                //url -> jdbc:mysql://localhost:3306/20_db?characterEncoding=utf-8&amp;&amp;serverTimezone=GMT
            [3]提供一个JdbcTemplate实例，并且配置上datasource。
            [4]声明sql字符串
            [5]通过jdbcTemplate.queryForObject(sql,String.class,args)来查询数据库，并返回结果。
        【Spring的形式】IocTest、application.xml
            [1]此时再导入spring-context、spring-test，创建spring环境。
            [2]在spring配置文件中注册datasource、jdbcTemplate组件。
                   //new -> <bean>标签、set方法 -> <property>标签
                   //& -> &amp;
            [3]IocTest类中注入JdbcTemplate对象，之后的测试同se形式。
        【增加dao层】
            [1]把jdbcTemplate的导入和使用交给AccountDao，接口只提供外部一个方法selectNameById()。
            [2]IocTest类只需要导入AccountDao并调用selectNameById()方法就可以对数据库进行查询操作。
        【jdbcDaoSupport这块没懂，跳过】
----【demo2-propagation_introduction】
        【知识点】
            事务的4个特性： A-原子性、C-一致性、I-隔离性、D-持久性
            并发引起的问题：脏读、不可重复读、幻读（虚读）
                脏读：线程A读取了被线程B修改后但未提交的数据。
                不可重复读：线程A读取了被线程B修改后且已提交的数据。//修改
                幻读：线程A读取了被线程B进行增删操作后且已提交的数据。//增删
            数据库隔离级别：
                [        脏读 不可重复读 幻读]
                [读未提交  ×      ×      × ]
                [读已提交  √      ×      × ]  Oracle的默认隔离级别
                [可重复读  √      √      × ]  Mysql的默认隔离级别
                [序列化    √      √      √ ]
            Spring事务的核心API：
                PlatFormTransactionManager
                TransactionStatus //事务状态
                    isNewTransaction() //是否是新的事务
                    hasSavepoint()     //是否有保存点
                    setRollbackOnly()  //设置回滚
                    isRollbackOnly()   //是否回滚
                    flush              //刷新
                    isComplete()       //是否完成
                TransactionDefinition //定义事务的名称、隔离级别、传播行为、超时时间长短、只读属性
            事务的传播行为：
                Required：新建一个事务，如果存在一个事务就加入它，一起提交一起回滚 //一荣俱荣、一损俱损
                Requires_new：总是新建一个事务，如果存在一个事务则将其挂起 //自私的事务，我可以影响别人，别人不可以影响我。
                nested：嵌套，如果有一个事务，则已嵌套事务的形式存在 //集体和个人，我不可以影响别人，别人可以影响我。
        【demo2只是构建一个事务的场景】pom.xml、UserService、AccountService
----【demo3-tx_template】
        【导包】spring-context、spring-test、spring-jdbc、junit
               druid、mysql-connector-java
        【Spring配置】
               注册datasource、jdbcTemplate
        【dao层】AccountDao、AccountDaoImpl
               //和数据库直接打交道
               包含两个方法：selectMoneyById()、updateMoneyById()
               jdbcTemplate(sql,int.class,id)、jdbcTemplate(sql,money,id)
        【service层】AccountService、AccountServiceImpl
               //具体的业务逻辑实现
               包含一个转账方法：transfer()，指定转账者给收账者转多少钱。
               注入AccountDao，并调用selectMoneyById()、updateMoneyById()进行计算。
        【没有增加事务出现问题】
                此时，在两条updateMoneyById()语句直接制造一个除零异常，运行代码发现数据库中，转账者转了钱，但是收账者并没有收到钱。
        【采用手动管理事务的方式】
                [1]配置文件中注册事transactionManager
                    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
                        <property name="dataSource" value="datasource"/>
                    </bean>
                [2]继续注册transactionTemplate
                    <bean id="transactionTemplate" class="org.springframework.transaction.support.TransactionTemplate">
                        <property name="transactionManager" value="transactionManager"/>
                    </bean>
                [3]修改AccountServiceImpl
                    将涉及到更改数据库的代码作为一个事务处理，要么全部都执行，要么全部都不执行。
                    [1]注入transactionTemplate
                    [2]
                        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                            @Override
                            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                                //当作一个事务处理的代码。
                            }
                        });
                [4]测试：此时报除零异常，且不会出现数据库更改不一致的问题。
----【demo4-tx_proxy】
        【配置和业务代码直接复制demo3】
             关闭采用了事务的代码，开启没有采用事务的代码 //此时不再注入TransactionTemplate
             application.xml只保留基础保障性的组件（DruidDataSource、JdbcTemplate）
                            注释掉DataSourceTransactionManager、TransactionTemplate
             测试：此时报除零异常，且会出现数据库更改不一致的问题。
        【生成代理对象、SpringAOP形式】
             application.xml中打开DataSourceTransactionManager。//TransactionTemplate保持关闭
             注册一个TransactionProxyFactoryBean
                 [1]target -> accountServiceImpl  //代理的目标对象（其中包含需要采取事务处理的方法）
                 [2]transactionManager -> transactionManager  //事务管理器
                 [3]transactionAttributes
                      <props> -> <prop key="transfer">PROPAGATION_REQUIRED,ISOLATION_REPEATABLE_READ,timeout_5</prop>
                          //测试：此时报除零异常，且不会出现数据库更改不一致的问题。
                      <props> -> <prop key="transfer">PROPAGATION_REQUIRED,ISOLATION_REPEATABLE_READ,timeout_5,+java.lang.ArithmeticException</prop>
                          //测试：此时报除零异常，且会出现数据库更改不一致的问题。
                          //+java.lang.ArithmeticException 意味着 发生这个异常的时候依然提交
                 【关注一下事务定义的写法】
                      key = 方法名 value = definition
                      propagation → PROPAGATION_REQUIRED PROPAGATION_REQUIRES_NEW
                      isolation → ISOLATION_REPEATABLE_READ ISOLATION_DEFAULT
                      timeout → timeout_5 5秒超时时间，单位是秒
                      readonly → 如果只读就只写readonly
                      +XXXException → 针对xxx这个异常不回滚，发生xxx异常依然提交
                      -xxxException → 针对xxx这个异常回滚
----【demo5-tx_advisor】
        【依赖、配置、业务代码】
             直接复制demo4的依赖
                 另外导入aspectjweaver
             直接复制demo5的纯业务代码
             直接复制业务代码相关组件注册
                 只保留DruidDataSource、JdbcTemplate
        【application.xml】
            【使用tx标签，修改application.xml，同时更改application.xml的模板】
             //增加DataSourceTransactionManager
             [1]spring事务给我们提供了一个advice → 需要使用到一个tx的标签 tx的schema
                  <tx:advice> -> id、transaction-manager
                      <tx:attributes>  //定义
                          <tx:method>  //<tx:method name="transfer" propagation="REQUIRED" isolation="REPEATABLE_READ" timeout="5"/>
                                           //测试：此时报除零异常，且不会出现数据库更改不一致的问题。
                                       //<tx:method name="transfer" propagation="REQUIRED" isolation="REPEATABLE_READ" timeout="5" read-only="true"/>
                                           //测试：提示出错（Connection is read-only），因为此时service层有修改数据库的操作。
             [2]手动写了一个advice类 implements MethodInterceptor接口
                  <aop:config>
                      <aop:pointcut> -> id、expression
                      <aop:advisor> -> advice-ref、pointcut-ref
----【demo6-tx_annotation】
         //该方式最简单、最重要！！！
        【直接复制demo5的依赖和纯业务代码】
        【application.xml】
            //基本配置
              [1]<context:component-scan>
              [2]DruidDataSource
              [3]JdbcTemplate
            //最终配置
              [4]DataSourceTransactionManager
            //注解驱动 注解开关
              [5]<tx:annotation-driven> -> transaction-manager
        【AccountServiceImpl.java】
            transfer()方法上增加@Transactional注解
                测试：此时报除零异常，且不会出现数据库更改不一致的问题。
            @Transaction注解还可以添加各种属性
                例如：
                    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,
                                   readOnly = true,noRollbackFor = java.lang.ArithmeticException.class)
----【demo7-tx_annotation_javaconfig】
        【Application.java】
            【类上的注解】
                @Configuration
                @ComponentScan(basePackages = "com.bupt")
                @EnableTransactionManagement
                @EnableAspectJAutoProxy
            【方法】
                [1]druidDatasource()
                    //@Bean注解中可以指定组件的id
                    //@Bean注解中如果没有指定id，以方法名作为默认的id
                    //方法体里面写一个实例化的过程
                    //new后面跟的class与<bean>标签中的class属性一致
                [2]jdbcTemplate()
                    //如果当前组件依赖于容器中的其他组件，可以通过传入形参的形式来进行引用
                    //如果这个类型的组件不止一个，通过@Qualifier来指定id，使用方式就类似于Autowired
                [3]transactionManager()
            【测试】
                【疑问！！！】如何测试？没有对应部分的代码。
---------------------------------------------------------------------------------------------------------------------------------------------------------------
【SpringMVC01】
----【demo1-web】
         【web项目的结构】
             web包 -> tomcat
             web-root
             --WEB-INF
               --class（java和resource里的代码和文件）
               --lib
               --xxxjsp（不能够直接访问的资源）
               --web.xml
             --（直接可以访问的资源）
         【pom.xml】
             导入servlet依赖
         【web.xml】
             创建webapp/WEB-INF下的web.xml
         【打包】
             按照这样的目录结构打包到tomcat下运行
             目的：当放发生一些异常的时候，检测打包的目录结构是否符合要求
             目录结构在哪里看？project structure中有一个actifact:war exploded
                 如何生成这个war exploded？ -> 手动生成（不建议）
                                          -> 自动生成 -> pom.xml文件中增加一个packaging=war
         【pom.xml】
             增加<packaging>war</packaging>，webapp图标出现小蓝点
                 小蓝点意味着这是web项目的根路径
                 //【注意】我添加war后，webapp图标并没有立即出现小蓝点
                          文件 -> 项目结构 -> facets -> "+"web项目（选择demo1-web）
                              之后才出现小蓝点
                          文件 -> 项目结构 -> Artifacts -> "+"War Application Exploded
                              会自动帮我们把依赖放入到WEB-INF的lib目录中
             //IDEA中的代码如何打包成web标准目录结构。//决定项目是否能够跑起来。
             //在IDEA中使用Tomcat
                 编辑配置 -> Application Server（指定Tomcat）
                         -> （指定浏览器）
                         -> URL（http://localhost:8080/）
                         -> Deployment（"+" -> Select Artifacts to Deploy）
                                      （Application context）
          【增加HelloServlet.java、web.xml、index.jsp中的逻辑】
----【demo2-start】
         【pom.xml】
             spring-webmvc（5spring+2springmvc+1jcl）、
                          //spring-aop、spring-beans、spring-context、spring-core、spring-expression、
                          //spring-web、spring-webmvc、
                          //spring-jcl
             servlet-api  //注意<scope>provided</scope>
             增加<packaging>war</packaging>
             //部署完成后，target/demo2-start-1.0-SNAPSHOT/WEB-INF/lib目录下可以看到导入的jar包
         【web.xml】
             <servlet>标签、<servlet-mapping>标签：
                 <servlet>
                     <servlet-name>
                     <servlet-class>
                 </servlet>
                 <servlet-mapping>
                     <servlet-name>
                     <servlet-url>
                 </servlet-mapping>
             //将org.springframework.web.servlet.DispatcherServlet类对应的url设置为/
                 此时，除了web根路径下的资源，都要经过DispatcherServlet
         【构建spring环境】
             【web.xml】
             //在web项目中使用spring
                 <servlet>标签中增加一个<init-param>子标签：
                     <init-param>
                         <param-name>contextConfigLocation</param-name>
                         <param-value>class:application.xml</param-value>
                     </init-param>
             【application.xml】
             //注册组件
                 //handlerMapping 以组件的id作为请求的url来进行映射
                 <bean class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"/>
                 //handlerAdapter
                 <bean class="org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter"/>
                 //handler simpleController → implements Controller   //【注意】这里除了xml组件注册的方式，还可以采用注解的形式：在HelloController类上加上@Component("/hello")
                 <bean id="/hello" class="com.bupt.controller.HelloController"/>
         【业务代码】
             HelloController 继承 Controller  //org.springframework.web.servlet.mvc.Controller
                 实现handleRequest()方法  //参数类型：HttpServletRequest、HttpServletResponse
                                         //返回值类型：ModelAndView
                     ModelAndView modelAndView = new ModelAndView();
                     //view  viewName写的是相对于web根路径下的视图,写的时候注意最前面有个/
                     modelAndView.setViewName("/WEB-INF/view/hello.jsp");
                     //model
                     modelAndView.addObject("key","czgbyer6666");
                     return modelAndView;
             /WEB-INF/view目录中增加一个hello.jsp文件
                 其中，${key}引入的内容就是addObject()方法中设置的值。
         【小结】
             目前一个url对应一个类，还不够灵活。
----【demo3-request_mapping】
         【pom.xml】
             //war
             //spring-webmvc、servlet-api
         【web.xml】
             //DispatcherServlet、class:application.xml
         【application.xml】
             //<context:component-scan/>
             //<mvc:annotation-driven/>  //重要：包含了handlerMapping handlerAdapter等一些必须的组件
         【业务代码】
             /WEN-INF/view/hello.jsp、HelloController.java
             //重要：此时不再使用demo2的繁杂形式
                 HelloController无需继承Controller，而是采用@Controller注解的形式；
                 也无需实现Controller的handleRequest()方法；
                     直接定义一个放回置类型为ModelAndView的方法（也无需参数HttpServletRequest、HttpServletResponse）
                     在方法上直接加上@RequestMapping注解（表明url）
             //而且，此时可以在同一个Controller中实现多个方法，每个方法都是一个handler，将url与方法建立映射关系。
         【扩展】
             在Controller类中可以注入ApplicationContext对象，
                 并且选择一个方法，通过遍历applicationContext.getBeanDefinitionNames()可以看到，
                     mvc:annotation-driven还帮我们注册很多其他的组件。
----【demo4-url_mapping】
         【pom.xml、web.xml、application.xml】
         【url路径映射】
             【多个url映射到同一个方法上】
                 //同一个handler可以接受多个url的映射
                     //例如，对于hello1()方法，可以在方法上加上@RequestMapping(value = {"hello11","hello12","hello13"})
             【可以使用通配符*】
                 //可以通配一个单词的一部分或者一级目录
                     [1]通配一个单词的一部分
                     //@RequestMapping("hello2*")       // hello2、hello21、hello222
                     [2]通配一级目录
                     //@RequestMapping("hello3/*/abc")  // hello3/abc/abc、hello3/abc/abc
             【一个url映射到多个handler方法】
                 可以，后面才能做。
         【窄化请求@RequestMapping】
             UserController中有3个方法：register、login、delete，@RequestMapping注解上对应的url路径为：user/register、user/login、user/delete
             接下来进行窄化请求：
                 在UserController类上加上注解@RequestMapping("user")
                 此时3个方法对应的url为：register、login、delete
             窄化请求的反面案例：
                 类上加注解@Controller("user") -> 方法上加注解@RequestMapping("login")
                 访问localhost:8080/user/login  失败
                 访问localhost:8080/login  成功
                 原因：@Controller("user")是在注册组件UserController的id，而非进行窄化请求。
         【请求方法限定】
             请求方法限定的案例：
                 类上加注解@Controller("method")
                     -> get()方法上加注解 @RequestMapping(value="get",method=RequestMethod.GET)
                     -> post()方法上加注解 @RequestMapping(value="post",method=RequestMethod.POST)
                     -> multi()方法上加注解 @RequestMapping(value="multi",method={RequestMethod.GET,RequestMethod.POST})
                 使用postman测试：
                     GET请求访问：localhost:8080/method/get  成功
                     POST请求访问：localhost:8080/method/get  失败
                     GET请求访问：localhost:8080/method/post  失败
                     POST请求访问：localhost:8080/method/post  成功
                     GET请求访问：localhost:8080/method/multi  成功
                     POST请求访问：localhost:8080/method/multi  成功
             另外，可以在方法上直接加注解 @GetMapping("get")、@PostMapping("post")
         【请求参数限定】
             【必须要有特定的参数】
                 类上加注解@Controller("parameter")
                     -> login()方法上加注解 @RequestMapping(value="login",param="username")
                 测试：
                     访问：localhost:8080/method/login  失败
                     访问：localhost:8080/method/login?username=czgbyer  成功
             【多个参数之间的关联】
                 param={"username","password"}
                     //参数username和password直接是and关系
                 测试：
                     访问：http://localhost:8080/parameter/login?username=root  失败
                     访问：http://localhost:8080/parameter/login?password=123456  失败
                     访问：http://localhost:8080/parameter/login?username=root&password=123456  成功
                     访问：http://localhost:8080/parameter/login?password=123456&username=root  成功
             【做一个简单的参数值的限定】
                 param={"username!=root","password"}
                     //限定了请求参数username的值不能为root
                 测试：
                     访问：http://localhost:8080/parameter/login?username=root&password=123456  失败
                     访问：http://localhost:8080/parameter/login?username=czgbyer&password=123456  成功
         【Content-Type和Accept】
             【疑问：没太懂这一块】
             consumes=String[] Content-Type  //提交给服务器的参数类型
             produces=String[] Accept        //服务器接收的参数类型
                 ProduceConsumeLimitController类的
                     consume()方法上加注解@RequestMapping(value = "consume", consumes = "application/abc")
                     produce()方法上加注解@RequestMapping(value = "produce", produces = "application/json")
                 使用postman测试：
                     访问：http://localhost:8080/consume
                         没有选择Content-Type  失败
                         选择Content-Type，且值为application/abc  成功
                         选择Content-Type，且值为application/abcz  失败
                     访问：http://localhost:8080/produce
                         没有选择Accept  成功
                         选择Accept，且值为application/json  成功
                         选择Accept，且值为application/jsonz  失败
----【demo5-return_value】
         【pom.xml、web.xml、application.xml】
             都直接复制demo4的
         【返回void】
             //返回值为void并不推荐使用
             ReturnValueController类上加注解@Controller
             returnVoid()方法的返回值类型为void，参数类型为：HttpServletRequest、HttpServletResponse
                 request.getRequestDispatcher("/WEB-INF/view/void.jsp").forward(request,response);
             测试：
                 访问：http://localhost:8080/return/void 成功
         【返回String】
             //最终还是想处理ModelAndView
             returnString()方法的返回值类型为String，参数类型为：Model
                 model.addAttribute("key","czgbyer nb666 !!!");
                 return "/WEB-INF/view/string.jsp";
             测试：
                 访问：http://localhost:8080/return/string 成功
                 【去掉viewName前面的/】
                     再访问：http://localhost:8080/return/string 失败   //实际访问的是：http://localhost:8080/return/WEB-INF/view/string.jsp
                     如果把前面的/去掉了，那么访问的就是一个相对的页面；相对于请求url的一个页面。
                     url:/hello  viewname: WEB-INF/view/hello.jsp
                         → /WEB-INF/view/hello.jsp
                     url:/hello/abc/def  viewname:view/hello.jsp
                         → /hello/abc/view/hello.jsp
             【逻辑视图名】
                 在application.xml中进行如下配置：
                     <!--视图解析器 配置逻辑视图名-->
                     <!--配置之后所有的视图名都做拼接-->
                     <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
                         <property name="prefix" value="/WEB-INF/view/"/><!--前缀-->
                         <property name="suffix" value=".jsp"/><!--后缀-->
                     </bean>
                 此时，returnString()方法只需返回 “string”，即可正确访问。
                 测试：
                     returnString()方法返回 “string”
                     访问：http://localhost:8080/return/string  成功
                     returnString()方法返回 “/WEB-INF/view/string.jsp”
                     访问：http://localhost:8080/return/string  失败  //返回的是 “/WEB-INF/view//WEB-INF/view/string.jsp.jsp”
---------------------------------------------------------------------------------------------------------------------------------------------------------------
【SpringMVC02】
----【demo1-forward_redirect】
         【pom.xml、web.xml、application.xml】
             都直接复制SpringMVC01的demo4的
         StringHelloController类上加注解@Controller
             包含4个方法：forward()、receiveForward()、redirect()、receiveRedirect()
             对应的url为：request/forward、receive/forward、request/redirect、receive/redirect
             其中，forward()方法通过 return "forward:/receive/forward"; 转发到receiveForward()方法；  //这里，/receive/forward不是viewName，而是url
                  redirect()方法通过 return "redirect:/receive/redirect"; 重定向到receiveRedirect()方法。  //这里，/receive/redirect不是viewName，而是url
                  //注意最前面加上/,如果不加的话，做的也是相对路径
                  receiveForward()方法 return "/WEB-INF/view/forward.jsp";
                  receiveRedirect()方法 return "/WEB-INF/view/redirect.jsp";
         测试：
             访问：http://localhost:8080/request/forward
                  成功显示forward.jsp的内容。
                  结果页面仍然为：http://localhost:8080/request/forward
             访问：http://localhost:8080/request/redirect
                  成功显示redirect.jsp的内容。
                  结果页面变为：http://localhost:8080/receive/redirect
----【demo2-fetch_param】
         【pom.xml、web.xml、application.xml】
             都直接复制SpringMVC01的demo4的
         【通过request获取参数】
             原始的方式 -> javaee阶段的方式
             ParamController -> paramRequest() //paramRequest()方法的参数类型为HttpServletRequest
             paramRequest()方法中通过request.getParameter()获取请求参数。
             测试1：
                 访问：http://localhost:8080/param/request?username=czgbyer  成功，控制台打印出username信息。
             测试2：
                 此时再webapp目录下新增一个index.jsp，通过form表单填写请求参数。
                 访问：http://localhost:8080  成功，跳转到http://localhost:8080/param/request，控制台打印出username信息。
         【直接封装】
             ParamController -> paramDirect()
             //paramDirect()方法的参数名等于请求的参数名
             //注解接收的参数：值类型String、int、double、boolean
             测试：
                 访问：http://localhost:8080  成功，跳转到http://localhost:8080/param/direct，控制台打印出username、password信息。
             【以包装类接收】
                 以非包装类（int、double、boolean）直接封装存在问题，如果请求参数的值没有填写会访问失败。
                     但是只有String类型的参数的值不填写，则不会访问失败。
                 //没有提交的参数的默认值为String类型的null，无法转换成非包装类的boolean和int类型，而包装类Boolean和Integer是可以的。
             测试1：
                 以int、boolean类型接收参数
                 不填写int、boolean类型参数对应的值，则访问失败
             测试2：
                 以Int、Boolean类型接收参数
                 不填写Int、Boolean类型参数对应的值，则访问仍然成功，控制台输出对应参数的值均为null。
         【以javabean的形式接收】
             pom.xml导入lombok；新建User类；User类和index.jsp中包含username、password、age、married
             将post参数全部封装到User中，请求参数直接为User类型。
             //注意：set方法的名称要和请求参数名称对应。
             测试：
                 访问：http://localhost:8080  成功，跳转到http://localhost:8080/param/javabean，控制台输出user信息。
         【以嵌套javabean的形式接收】
             再新建一个UserDetail对象，将phone、email封装到UserDetail中。
             index.jsp中phone和email对应的name为 userDetail.phone、userDetail.email
             User类中新增一个UserDetail类型的成员变量
             ParamController类中的paramDirect()方法还是以User类型接收参数。
             测试：
                 访问：http://localhost:8080  成功，跳转到http://localhost:8080/param/javabean/nested，控制台输出user信息（包含userDetail信息）。
         【javabean中的数组】
             index.jsp中3个爱好的name都是hobbys
             User类中新增一个String[]类型的hobbys
             测试：
                 访问：http://localhost:8080  成功，跳转到http://localhost:8080/param/javabean/nested/array，控制台输出user信息（包含userDetail信息）（包含hobbys信息）。
         【javabean中的list】
             新建一个Course类，包含courseName、score
             User类中新增List<Course>类型的成员变量courses
             index.jsp中，提交3个课程信息，对应的name分别是courses[0].courseName、courses[0].score、courses[1].courseName、courses[1].score、courses[2].courseName、courses[2].score
             测试：
                 访问：http://localhost:8080  成功，跳转到http://localhost:8080/param/javabean/nested/list，控制台输出user信息（包含userDetail信息）（包含hobbys信息）（包含课程信息）。
---------------------------------------------------------------------------------------------------------------------------------------------------------------
【SpringMVC03】
---------------------------------------------------------------------------------------------------------------------------------------------------------------
【SpringMVC04】
---------------------------------------------------------------------------------------------------------------------------------------------------------------
【Mybatis01】
---------------------------------------------------------------------------------------------------------------------------------------------------------------
【Mybatis02】
---------------------------------------------------------------------------------------------------------------------------------------------------------------
【Mybatis03】
---------------------------------------------------------------------------------------------------------------------------------------------------------------
【Mybatis04】
---------------------------------------------------------------------------------------------------------------------------------------------------------------
【Mybatis05】
---------------------------------------------------------------------------------------------------------------------------------------------------------------


