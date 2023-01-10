# spring-aot-issue-1

Creating a bean definition manually and having `Set` containing types(Like Class) which doesn't implement `Comparable` fails in aot processing.

Workaround is to use some other type like `List` or plain array.

```
> Task :processAot FAILED

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.0.1)

2023-01-10T09:22:26.403Z  INFO 15936 --- [           main] com.example.demo.DemoApplication         : Starting DemoApplication using Java 17.0.5 with PID 15936 (/tmp/xxx/aot-issue/build/classes/java/main started by jvalkealahti in /tmp/xxx/aot-issue)
2023-01-10T09:22:26.406Z  INFO 15936 --- [           main] com.example.demo.DemoApplication         : No active profile set, falling back to 1 default profile: "default"
Exception in thread "main" java.lang.IllegalArgumentException: Failed to generate code for '[class java.lang.String]' with type java.util.HashSet<?>
        at org.springframework.beans.factory.aot.BeanDefinitionPropertyValueCodeGenerator.generateCode(BeanDefinitionPropertyValueCodeGenerator.java:101)
        at org.springframework.beans.factory.aot.BeanDefinitionPropertiesCodeGenerator.generateValue(BeanDefinitionPropertiesCodeGenerator.java:186)
        at org.springframework.beans.factory.aot.BeanDefinitionPropertiesCodeGenerator.lambda$addConstructorArgumentValues$3(BeanDefinitionPropertiesCodeGenerator.java:151)
        at java.base/java.util.LinkedHashMap.forEach(LinkedHashMap.java:721)
        at java.base/java.util.Collections$UnmodifiableMap.forEach(Collections.java:1553)
        at org.springframework.beans.factory.aot.BeanDefinitionPropertiesCodeGenerator.addConstructorArgumentValues(BeanDefinitionPropertiesCodeGenerator.java:150)
        at org.springframework.beans.factory.aot.BeanDefinitionPropertiesCodeGenerator.generateCode(BeanDefinitionPropertiesCodeGenerator.java:119)
        at org.springframework.beans.factory.aot.DefaultBeanRegistrationCodeFragments.generateSetBeanDefinitionPropertiesCode(DefaultBeanRegistrationCodeFragments.java:146)
        at org.springframework.beans.factory.aot.BeanRegistrationCodeGenerator.generateCode(BeanRegistrationCodeGenerator.java:86)
        at org.springframework.beans.factory.aot.BeanDefinitionMethodGenerator.lambda$generateBeanDefinitionMethod$3(BeanDefinitionMethodGenerator.java:187)
        at org.springframework.aot.generate.GeneratedMethod.<init>(GeneratedMethod.java:54)
        at org.springframework.aot.generate.GeneratedMethods.add(GeneratedMethods.java:112)
        at org.springframework.aot.generate.GeneratedMethods.add(GeneratedMethods.java:89)
        at org.springframework.beans.factory.aot.BeanDefinitionMethodGenerator.generateBeanDefinitionMethod(BeanDefinitionMethodGenerator.java:181)
        at org.springframework.beans.factory.aot.BeanDefinitionMethodGenerator.generateBeanDefinitionMethod(BeanDefinitionMethodGenerator.java:102)
        at org.springframework.beans.factory.aot.BeanRegistrationsAotContribution.lambda$generateRegisterBeanDefinitionsMethod$2(BeanRegistrationsAotContribution.java:85)
        at java.base/java.util.LinkedHashMap.forEach(LinkedHashMap.java:721)
        at org.springframework.beans.factory.aot.BeanRegistrationsAotContribution.generateRegisterBeanDefinitionsMethod(BeanRegistrationsAotContribution.java:83)
        at org.springframework.beans.factory.aot.BeanRegistrationsAotContribution.lambda$applyTo$1(BeanRegistrationsAotContribution.java:67)
        at org.springframework.aot.generate.GeneratedMethod.<init>(GeneratedMethod.java:54)
        at org.springframework.aot.generate.GeneratedMethods.add(GeneratedMethods.java:112)
        at org.springframework.aot.generate.GeneratedMethods.add(GeneratedMethods.java:89)
        at org.springframework.beans.factory.aot.BeanRegistrationsAotContribution.applyTo(BeanRegistrationsAotContribution.java:66)
        at org.springframework.context.aot.BeanFactoryInitializationAotContributions.applyTo(BeanFactoryInitializationAotContributions.java:78)
        at org.springframework.context.aot.ApplicationContextAotGenerator.lambda$processAheadOfTime$0(ApplicationContextAotGenerator.java:58)
        at org.springframework.context.aot.ApplicationContextAotGenerator.withCglibClassHandler(ApplicationContextAotGenerator.java:67)
        at org.springframework.context.aot.ApplicationContextAotGenerator.processAheadOfTime(ApplicationContextAotGenerator.java:53)
        at org.springframework.context.aot.ContextAotProcessor.performAotProcessing(ContextAotProcessor.java:106)
        at org.springframework.context.aot.ContextAotProcessor.doProcess(ContextAotProcessor.java:84)
        at org.springframework.context.aot.ContextAotProcessor.doProcess(ContextAotProcessor.java:49)
        at org.springframework.context.aot.AbstractAotProcessor.process(AbstractAotProcessor.java:82)
        at org.springframework.boot.SpringApplicationAotProcessor.main(SpringApplicationAotProcessor.java:76)
Caused by: java.lang.ClassCastException: class java.lang.Class cannot be cast to class java.lang.Comparable (java.lang.Class and java.lang.Comparable are in module java.base of loader 'bootstrap')
        at java.base/java.util.TreeMap.compare(TreeMap.java:1569)
        at java.base/java.util.TreeMap.addEntryToEmptyMap(TreeMap.java:776)
        at java.base/java.util.TreeMap.put(TreeMap.java:785)
        at java.base/java.util.TreeMap.put(TreeMap.java:534)
        at java.base/java.util.TreeSet.add(TreeSet.java:255)
        at java.base/java.util.AbstractCollection.addAll(AbstractCollection.java:336)
        at java.base/java.util.TreeSet.addAll(TreeSet.java:309)
        at java.base/java.util.TreeSet.<init>(TreeSet.java:160)
        at org.springframework.beans.factory.aot.BeanDefinitionPropertyValueCodeGenerator$SetDelegate.orderForCodeConsistency(BeanDefinitionPropertyValueCodeGenerator.java:456)
        at org.springframework.beans.factory.aot.BeanDefinitionPropertyValueCodeGenerator$SetDelegate.generateCollectionCode(BeanDefinitionPropertyValueCodeGenerator.java:451)
        at org.springframework.beans.factory.aot.BeanDefinitionPropertyValueCodeGenerator$SetDelegate.generateCollectionCode(BeanDefinitionPropertyValueCodeGenerator.java:439)
        at org.springframework.beans.factory.aot.BeanDefinitionPropertyValueCodeGenerator$CollectionDelegate.generateCode(BeanDefinitionPropertyValueCodeGenerator.java:333)
        at org.springframework.beans.factory.aot.BeanDefinitionPropertyValueCodeGenerator.generateCode(BeanDefinitionPropertyValueCodeGenerator.java:128)
        at org.springframework.beans.factory.aot.BeanDefinitionPropertyValueCodeGenerator.generateCode(BeanDefinitionPropertyValueCodeGenerator.java:98)
        ... 31 more

```
