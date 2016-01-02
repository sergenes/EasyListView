[ ![Download](https://api.bintray.com/packages/sergenes/maven/easylistview/images/download.svg) ](https://bintray.com/sergenes/maven/easylistview/_latestVersion)

# EasyListView
With EasyListView you don't have to implement your own Adapter every time, when you need to show a simple list.


## How to use with Gradle
You can use the artifacts like this:
```groovy
dependencies {
	compile 'org.nes.easylistview:easylistview:1.0.0'
}
```

## Demo
To understand how to use this library please look at <a href='https://github.com/sergenes/EasyListView/tree/master/app/src/main/java/org/nes/easylistviewdemo' target='_blank'>demo project</a>.

## Sample
1. Define in layout
```xml
    <org.nes.easylistview.EasyListView
            android:id="@+id/staticTable"
            android:layout_width="match_parent"
            android:layout_height="match_parent">
    </org.nes.easylistview.EasyListView>
```
2. Get and populate in java
```java
        final EasyListView table = (EasyListView) findViewById(R.id.staticTable);

        SimpleRowItem item1 = new SimpleRowItem(this, R.layout.row_simple);
        SimpleRowItem item2 = new SimpleRowItem(this, R.layout.row_simple);
        CheckableRowItem item3 = new CheckableRowItem(this, R.layout.row_checkable);
        CheckableRowItem item4 = new CheckableRowItem(this, R.layout.row_checkable);
        CheckableRowItem item5 = new CheckableRowItem(this, R.layout.row_checkable);

        item1.setTitle("Test Row 1");
        item2.setTitle("Test Row 2");
        item3.setTitle("English").setChecked(true);
        item4.setTitle("Hebrew").setChecked(false);
        item5.setTitle("Russian").setChecked(false);

        table.getRowSource().add(item1);
        table.getRowSource().add(item2);
        table.getRowSource().add(item3);
        table.getRowSource().add(item4);
        table.getRowSource().add(item5);

        table.reloadData();

        table.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for(EasyListView.RowHolder r:table.getRowSource()){
                    r.setDefaultValues();
                }

                table.getRowSource().get(position).onClick();
            }
        });
```

Contact
=================================
If you are using this lib, let me know contacting me at serge.nes@gmail.com


License
=================================

    Copyright 2016 Sergey Nes

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.