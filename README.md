<h1 align="center">Code Generator</h1>
<div align="center">
快速自动代码生成器 :o: :x:
</div>

## ✨ 特性
- 🌈 最快两键可生成从数据库到接口的全部代码。
- ⚙️ 生成功能配置化，生成即可使用。
- 📦 使用SpringBoot和Swagger，基于MySQL和Mybatis。
- ⚡ 自动生成Swagger接口说明，免去粘贴复制痛苦。

## 🔨 原理
1. 🖥 先使用mybatis-generator自动生成4个文件，再从model生成VO、从dao的mapper生成service类、
  从service类生成serviceImpl类、从service类生成controller类。
2. 🌍 用到的技术则是文件读取和反射，简单而有效。

## ⌨️ 使用
搭好你的项目。下载本源码，一般将codegenerator包复制到你项目的/test/java/${packagename}下即可。
1. 🌐 配置generatorConfig.xml各项；
2. 🤝 配置GeneratorConfig.java各项；
3. 🐞 再配置GeneratorCodeOneTest.java的className和noteDesc；
    GeneratorCodeAllTest.java生成全部表时无需任何配置；
4. 📖 然后使用mybatis-generator生成如下文件：<br/>
  4.1 /mapper/TestMapper.xml <br/>
  4.2 /dao/TestMapper.java <br/>
  4.3 /model/Test.java <br/>
  4.4 /model/TestExample.java <br/>
5. 🔥 最后使用GeneratorCodeOneTest生产如下文件： <br/>
  5.1 /vo/TestVO.java <br/>
  5.2 /service/TestService.java <br/>
  5.3 /service/impl/TestServiceImpl.java <br/>
  5.4 /controller/TestController.java <br/>
6. 🌟 第一次在本地运行会出错，这时候需要修改源码，并不困难。
  
## 📦 更新
2021/04/25 更新
   1. 优化打印日志逻辑；
   2. 生成全部表代码逻辑。
   
2020/12/17 更新
   1. 引入标准状态码，优化生成逻辑。
   
2020/12/15 更新
   1. 优化代码，更新说明。

2020/12/01 首发
   1. 基本功能搭建，代码生成可用。

## 🌈 缺点
1. 代码集成度、定制化要求较高，开发适配需改动代码。
