# DrawableTextView
A TextView with resizable drawables and easier to set clicked and selected drawable

## v1.0.3<br>

[ ![Download](https://api.bintray.com/packages/geejoe/maven/drawabletextview/images/download.svg) ](https://bintray.com/geejoe/maven/drawabletextview/_latestVersion)

### 简介：

这是一个继承自TextView的组件，解决了原生TextView添加drawableLeft等不能在xml中定义大小的问题，<br>
并且实现了可直接在xml中定义点击和选择时的drawable效果及字体颜色，特别适用于制作Tab和需要图片修饰的item<br>

## 效果图
![](https://github.com/GeeJoe/DrawableTextView/raw/master/gif/2017-06-04_21_33_49.gif)

### 添加依赖：

本项目已同步到JCenter，可直接添加以来使用：

```Java
dependencies {
    compile 'com.geejoe:drawabletextview:1.0.2'
}
```

### 使用方法：

示例：
```xml
<com.geejoe.drawabletextview.DrawableTextView
        android:id="@+id/dt"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:text="hello world"
        app:leftDrawable="@drawable/ic_1"
        app:leftDrawableHeight="20dp"   <!--一定要设置width和height,否则无效-->
        app:leftDrawableWidth="20dp"
        app:leftClickedDrawable="@drawable/ic_2"   <!--点击时的drawable-->
        app:clickedTextColor="@color/colorPrimary" <!--点击时的字体颜色-->
	app:leftSelectedDrawable="@drawable/ic_2"  <!--选中时的drawable-->
        app:selectedTextColor="@color/colorPrimary"/><!--选中时的字体颜色-->  
```

## 注意：当设置了selectedDrawable之后，clickedDrawable将失效（实际应用中也不会需要点击和选中时效果不一样吧...）<br>
## 设置selectedDrawable之后，只需要在代码中相应的位置执行setSelected(boolean selected)方法即可切换选中效果
