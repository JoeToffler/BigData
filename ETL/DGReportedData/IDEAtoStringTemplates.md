## 背景
* IDEA自定义toString
* 可复用自定义方法

## 工具
* IDEA

## 使用
* IntelliJ IDEA插入toString()的快捷键是Alt+Insert，settings——>Templates

## 模板源码
    public java.lang.String toString() {
    #set ( $i = 0 )
    return ##
    #foreach ($member in $members)
    #if ( $i == 0 ) ##
    #else
    +'\t'+ ##
    #end
    $member.accessor ##
    #set ( $i = $i + 1 )
    #end
    ;
    }
    
## 模板效果
    public String toString() {
    return username + '\t' + password;
    }
    
## 模板语法说明
* 基本语法
    * $ 开头的是变量，
    * \## 是不换行，#set 是设置变量，$members 是属性集合，
    * $member.accessor 是属性值，$member.name 是属性名，

* 判断结构
#   
    #if
    
    #else
    
    #end

* 遍历结构
#
    #foreach (新变量 in 集合)

    #end
