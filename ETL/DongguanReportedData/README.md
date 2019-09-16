##Background
The project for system local data report the government data platform.  

##Install
This project uses java1.8,maven3.5.2 mysql3 and mongoDB.
Go check them out if you don't have locally installed. 

##Usage

##Deployment

##Directory

##Question
*出租屋居住人员信息表 国籍如何来，默认值是多少？
*t_app_tenant表中的nation确定不带"族"?
*证件类型感析平台只用身份证？

0.搭建项目
1.核对感析平台字段，建model
2.根据东莞数据规约建DTO
3.基础数据抽取

4.基础数据转换上报数据
5.根据上报数据大小进行条数限制处理及压缩
6.调用对应接口

注：
1."必填字段"缺省为“否”

东莞对接表：
     出租屋居住人员信息表
     出租屋房屋信息表
     出租屋门禁开门授权表
     出租屋门禁开门记录信息表
     出租屋门禁终端信息表
感析平台表：
     t_app_tenant Db-APP Tenant
     t_housemanagement_house  Db-House  House
     t_card_register  Db-rent  CardRegister
     t_devicemanagement_device  Db-Device  Device
          
两表映射关系：
     出租屋居住人员信息表  t_app_tenant  t_housemanagement_house
     出租屋房屋信息表  t_housemanagement_house
     出租屋门禁开门授权表 t_card_register
     出租屋门禁开门记录信息表 mongodb
     出租屋门禁终端信息表 t_devicemanagement_device

增加画面项目：
     增加需求字段
     
定时触发数据上报：
     时间暂定半天

数据项由统一分隔符$分开,换行符号统一为\r\n，
数据项的内容中原有的分隔符”$”，需由“\$”替换，
数据项目中的换行符统一由\\r\\n替代，对于数据项不允许为空的要求填默认值，
允许为空的值空串，直接用无字符替代。