# DrawableTextView
A TextView with resizable drawables and easier to set clicked and selected drawable

## v1.0.4<br>

[ ![Download](https://api.bintray.com/packages/geejoe/maven/drawabletextview/images/download.svg) ](https://bintray.com/geejoe/maven/drawabletextview/_latestVersion)

### 简介：

这是一个继承自TextView的组件，解决了原生TextView添加drawableLeft等不能在xml中定义大小的问题，<br>
并且实现了可直接在xml中定义点击和选择时的drawable效果及字体颜色，特别适用于制作Tab和需要图片修饰的item<br>

### 版本更新：V1.0.4
增加NavLayout，配合DrawableTextView使用，更方便地开发导航类空间，帮助你实现UI效果，把更多精力投入到逻辑开发中

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

### 注意：当设置了selectedDrawable之后，clickedDrawable将失效（实际应用中也不会需要点击和选中时效果不一样吧...）<br>
### 设置selectedDrawable之后，只需要在代码中相应的位置执行setSelected(boolean selected)方法即可切换选中效果

#### v1.0.4 提供了更简单的开发导航Tab控件方法：

##### 1> 设置点击和选中效果一步解决：
只需设置clickedColor或者selectedColor即可，例如：
```xml
<com.geejoe.drawabletextview.DrawableTextView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:text="nav1"
            app:selectedColor="@color/colorPrimary"
            app:topDrawable="@drawable/ic_1"
            app:topDrawableHeight="10dp"
            app:topDrawableWidth="10dp" />
```
这样就可以在选中时，文字和图片颜色变为ColorPrimary了

##### 2> 新增NavLayout，实现导航Tab单选效果
很多时候，开发导航栏时，需要实现选中其中一个导航，使其他呈现未选中状态，这时候只需要使用NavLayout就可以轻松实现，例如：

```xml
<com.geejoe.drawabletextview.NavLayout
        android:id="@+id/nav_v"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">

        <com.geejoe.drawabletextview.DrawableTextView
            android:layout_width="match_parent"
            android:layout_height="48dp"
            android:layout_marginBottom="5dp"
            android:background="#fcfcfc"
            android:drawablePadding="10dp"
            android:gravity="center_vertical"
            android:paddingStart="5dp"
            android:text="nav1"
            app:leftDrawable="@drawable/ic_1"
            app:leftDrawableHeight="10dp"
            app:leftDrawableWidth="10dp"
            app:selectedColor="@color/colorPrimary" />

        <com.geejoe.drawabletextview.DrawableTextView
            android:layout_width="match_parent"
            android:layout_height="48dp"
            android:layout_marginBottom="5dp"
            android:background="#fcfcfc"
            android:drawablePadding="10dp"
            android:gravity="center_vertical"
            android:paddingStart="5dp"
            android:text="nav2"
            app:leftDrawable="@drawable/ic_1"
            app:leftDrawableHeight="10dp"
            app:leftDrawableWidth="10dp"
            app:selectedColor="@color/colorPrimary" />

        <com.geejoe.drawabletextview.DrawableTextView
            android:layout_width="match_parent"
            android:layout_height="48dp"
            android:layout_marginBottom="5dp"
            android:background="#fcfcfc"
            android:drawablePadding="10dp"
            android:gravity="center_vertical"
            android:paddingStart="5dp"
            android:text="nav3"
            app:leftDrawable="@drawable/ic_1"
            app:leftDrawableHeight="10dp"
            app:leftDrawableWidth="10dp"
            app:selectedColor="@color/colorPrimary" />

        <com.geejoe.drawabletextview.DrawableTextView
            android:layout_width="match_parent"
            android:layout_height="48dp"
            android:layout_marginBottom="5dp"
            android:background="#fcfcfc"
            android:drawablePadding="10dp"
            android:gravity="center_vertical"
            android:paddingStart="5dp"
            android:text="nav4"
            app:leftDrawable="@drawable/ic_1"
            app:leftDrawableHeight="10dp"
            app:leftDrawableWidth="10dp"
            app:selectedColor="@color/colorPrimary" />

    </com.geejoe.drawabletextview.NavLayout>
```
上面的代码，在NavLayout下有四个DrawableTextView，效果如图：
![](https://github.com/GeeJoe/DrawableTextView/raw/master/gif/2017-06-05_20_12_33.gif)
图中上面部分是竖直布局的导航
图中下面部分是水平布局的导航
切换布局方向只需要设置NavLayout的orientation属性

##### 3> 提供OnNavSelectedListener接口,不用再设置繁琐的OnClickListener
NavLayout提供OnNavSelectedListener接口，实现该接口可以监听导航点击事件