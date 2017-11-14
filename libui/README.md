# 导出 AAR
- 打开 Gradle projects，依次展开 AndroidWT -> libui -> Tasks -> build，双击 assemble
- 这时打开文件夹 libui -> build -> outputs -> aar，将看到自动生成的 libui-debug.aar 和 libui-release.aar
- 如果只想生成 libui-release.aar，则双击 assembleRelease
- 如果只想生成 libui-debug.aar，则双击 assembleDebug

# 其他 project 引用 AAR

- 建立 LibInvoke
- 打开文件夹 LibInvoke -> app -> libs，将之前生成的 libui-release.aar 复制进来
- 打开 app 的 build.gradle，增加配置后点击 Sync Now 按钮
- 增加的配置如下：

`repositories{
 flatDir{
     dirs 'libs'
 }
}`

`compile(name:'libui-release',ext:'aar')`

- 使用 AAR 中的公共 class 和 String 资源

# 增强
- AAR 中的所有资源在默认情况下均处于公开状态。要将所有资源隐式设为私有，您必须至少将一个特定的属性定义为公开。资源包括您项目的 res/ 目录中的所有文件，例如图像。在 AAR 的 res/values/ 目录中创建 public.xml 文件，增加需要公开的资源（不在文件中的资源将不公开）。

`
<resources>
    <public name="hc_string" type="string"/>
</resources>
`

# AAR 文件详解
- AAR 文件的文件扩展名为 .aar，Maven 工件类型也应当是 aar。文件本身是一个包含以下强制性条目的 zip 文件：

`
/AndroidManifest.xml
/classes.jar
/res/
/R.txt
`

- 此外，AAR 文件可能包含以下可选条目中的一个或多个：

`
/assets/
/libs/名称.jar
/jni/abi 名称/名称.so（其中 abi 名称 是 Android 支持的 ABI 之一）
/proguard.txt
/lint.jar
`
# libui
- 打开 app 的 build.gradle，增加配置
`
repositories {
    flatDir {
        dirs 'libs'
    }
}
`


`
dependencies {
    compile(name: 'libui',ext:'aar')
}
`

- 调用aar中的activity
`
this.startActivity(new Intent(this, ActivityTest.class));
`

