# DrawableTextView
A TextView with resizable drawables and easier to set clicked and selected drawable

[ ![Download](https://api.bintray.com/packages/geejoe/maven/drawabletextview/images/download.svg) ](https://bintray.com/geejoe/maven/drawabletextview/_latestVersion)

### 简介：

这是一个继承自TextView的组件，解决了原生TextView添加drawableLeft等不能在xml中定义大小的问题，<br>
并且实现了可直接在xml中定义点击和选择时的drawable效果及字体颜色，特别适用于制作Tab和需要图片修饰的item<br>

如果想要开发导航类Tab控件，可参考[https://github.com/GeeJoe/EasyTab](https://github.com/GeeJoe/EasyTab "更简单的Tab控件开发")

## 效果图
![](https://github.com/GeeJoe/DrawableTextView/raw/master/gif/drawabletextview.gif)

### 添加依赖：

本项目已同步到JCenter，可直接添加以来使用：

```Java
dependencies {
    compile 'com.geejoe:drawabletextview:1.1.4'
}
```

### 使用方法：

#### 属性介绍

```xml
leftDrawable
```
显示在TextView最左边的Drawable<br>
```xml
leftDrawableWidth
```
左边Drawable的宽度，必须设置，否则Drawable不显示<br>
```xml
leftDrawableHeight
```
左边Drawable的高度，必须设置，否则Drawable不显示<br>
```xml
leftSelectedDrawable
```
当选中时（调用setSelected(true)方法之后）显示的Drawable<br>
```xml
leftClickedDrawable
```
当点击时显示的Drawable，若同时设置了selectedDrawable，会被selectedDrawable覆盖<br>
```xml
selectedTextColor
```
当被选中时（调用setSelected(true)方法之后）文字颜色<br>
```xml
clickedTextColor
```
当被点击时文字颜色<br>
```xml
selectedColor
```
当被选中时（调用setSelected(true)方法之后）对应的Drawable和文字会变成所选颜色，<br>
设置了该属性之后，selectedDrawable和selectedTextColor将无效<br>
```xml
clickedColor
```
当被点击时，对应的Drawable和文字会变成所选颜色，<br>
设置了该属性之后，clickedDrawable和clickedTextColor将无效<br>

下、右、上的Drawable和上述属性一样，只需要将上述属性中的left替换成对应的`bottom`|`right`|`top`即可

由上述属性介绍可以知道，当想要实现点击或者选中时更换图片，则需要设置`clickedDrawable`和`selectedDrawable`，<br>
想要改变文字颜色则设置`clickedTextColor`和`selectedTextColor`；<br>
如果单纯只是改变图片和字体颜色则只需要设置`clickedColor`和`selectedColor`就可以轻松实现。

> 注意：要实现点击效果需设置`clickable = true`，此时会导致外层布局无法响应点击事件（事件在这里被消耗）;若单纯想显示drawable而不需要点击效果建议设置`clickable = false`（默认为false）

下面贴出上示动图中三种DrawableTextView的xml实现：
第一种：
```xml
<com.geejoe.drawabletextview.DrawableTextView
            android:layout_width="match_parent"
            android:layout_height="48dp"
            android:background="#fcfcfc"
            android:drawablePadding="10dp"
            android:gravity="center_vertical"
            android:paddingEnd="5dp"
            android:paddingStart="5dp"
            android:text="拥有leftDrawable和rightDrawable的textView"
            android:textColor="@color/colorGray"
            app:leftDrawable="@drawable/nav_chat_default"
            app:leftDrawableHeight="10dp"
            app:leftDrawableWidth="10dp"
            app:rightDrawable="@drawable/more"
            app:rightDrawableHeight="8dp"
            app:rightDrawableWidth="8dp"
            app:clickedColor="@color/colorPrimary" />
```
第二种：
```xml
<com.geejoe.drawabletextview.DrawableTextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="#fcfcfc"
            android:gravity="center_horizontal"
            android:drawablePadding="10dp"
            android:padding="5dp"
            android:text="这是一个拥有topDrawable的TextView"
            android:textColor="@color/colorGray"
            app:topDrawable="@drawable/top_d"
            app:topDrawableHeight="10dp"
            app:topDrawableWidth="120dp"
            app:clickedColor="@color/colorPrimary" />
```
第三种：
```xml
<com.geejoe.drawabletextview.DrawableTextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginBottom="5dp"
            android:background="#fcfcfc"
            android:gravity="center_horizontal"
            android:drawablePadding="10dp"
            android:padding="5dp"
            android:text="这是一个拥有bottomDrawable的TextView"
            android:textColor="@color/colorGray"
            app:bottomDrawable="@drawable/down"
            app:bottomDrawableHeight="10dp"
            app:bottomDrawableWidth="10dp"
            app:clickedColor="@color/colorPrimary" />
```
