package com.xahi.reporteddata.schedule;

import com.alibaba.fastjson.JSONObject;
import com.xahi.reporteddata.constants.request.DataType;
import com.xahi.reporteddata.constants.result.ResultCode;
import com.xahi.reporteddata.dto.ResultDTO;
import com.xahi.reporteddata.model.*;
import com.xahi.reporteddata.repository.*;
import com.xahi.reporteddata.service.*;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author YangPeng
 * @describe 顶上上报数据
 * @date 2019-09-19 20:12
 */
@Log
@Service
public class ScheduleTask {
    class ScheduleRunnable implements Runnable {
        @Override
        public void run() {
        }
    }

    @Autowired
    TenantRepository tenantRepository;

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    RecordRepository recordRepository;

    @Autowired
    HouseRepository houseRepository;

    @Autowired
    CardRegisterRepository cardRegisterRepository;

    @Autowired
    ReportIndexRepository reportIndexRepository;


    @Autowired
    DongguanTenantsService tenantsService;

    @Autowired
    DongguanHouseService houseService;

    @Autowired
    DongguanCardRegisterService cardRegisterService;

    @Autowired
    DongguanDeviceService deviceService;

    @Autowired
    DongguanRecordService recordService;

    @Autowired
    ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @Value("${scheduled.houseTime}")
    private String houseTime;

    @Value("${scheduled.tenantTime}")
    private String tenantTime;

    @Value("${scheduled.authTime}")
    private String authTime;

    @Value("${scheduled.recordTime}")
    private String recordTime;

    @Value("${scheduled.terminalTime}")
    private String terminalTime;

    /**
     * 出租屋房屋信息表
     */
    public void uploadHouse() {
        threadPoolTaskScheduler.schedule(new ScheduleRunnable(), triggerContext -> {
            String tableName = DataType.XQ_YZXX.description;
            List<ReportIndex> indices = reportIndexRepository.findAll();
            try {
                if (indices.isEmpty() || indices.get(0).getHouseId() == null) {
                    List<House> all = houseRepository.findAll();
                    if (all.isEmpty()) {
                        log.info("出租屋房屋信息表暂无数据无法上传");
                    } else {
                        String result = houseService.reportData(all);
                        log.info(codeProcess(tableName, result));
                        processIndexByResponse(all, indices, result);
                    }
                } else {
                    Long houseId = indices.get(0).getHouseId();
                    List<House> all = houseRepository.findByIdGreaterThan(houseId);
                    if (all.isEmpty()) {
                        log.info("出租屋房屋信息表暂无更新数据无法上传");
                    } else {
                        String result = houseService.reportData(all);
                        log.info(codeProcess(tableName, result));
                        processIndexByResponse(all, indices, result);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new CronTrigger(houseTime).nextExecutionTime(triggerContext);
        });
    }

    /**
     * 出租屋居住人员信息表
     */
    public void uploadTenant() {
        threadPoolTaskScheduler.schedule(new ScheduleRunnable(), triggerContext -> {
            try {
                String tableName = DataType.XQ_FWXX.description;
                List<ReportIndex> indices = reportIndexRepository.findAll();
                if (indices.isEmpty() || indices.get(0).getTenantId() == null) {
                    List<Tenant> all = tenantRepository.findAll();
                    if (all.isEmpty()) {
                        log.info("出租屋居住人员信息表暂无数据无法上传");
                    } else {
                        String result = tenantsService.reportData(all);
                        log.info(codeProcess(tableName, result));
                        processIndexByResponse(all, indices, result);
                    }
                } else {
                    Long tenantId = indices.get(0).getTenantId();
                    List<Tenant> all = tenantRepository.findByIdGreaterThan(tenantId);
                    if (all.isEmpty()) {
                        log.info("出租屋居住人员信息表暂无更新数据无法上传");
                    } else {
                        String result = tenantsService.reportData(all);
                        log.info(codeProcess(tableName, result));
                        processIndexByResponse(all, indices, result);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new CronTrigger(tenantTime).nextExecutionTime(triggerContext);
        });
    }

    /**
     * 出租屋门禁开门授权表
     */
    public void uploadAuth() {
        threadPoolTaskScheduler.schedule(new ScheduleRunnable(), triggerContext -> {
            try {
                String tableName = DataType.XQ_MJKKSQXX.description;
                List<ReportIndex> indices = reportIndexRepository.findAll();
                if (indices.isEmpty() || indices.get(0).getAuthId() == null) {
                    List<CardRegister> all = cardRegisterRepository.findAll();
                    if (all.isEmpty()) {
                        log.info("出租屋门禁开门授权表暂无数据无法上传");
                    } else {
                        String result = cardRegisterService.reportData(all);
                        log.info(codeProcess(tableName, result));
                        processIndexByResponse(all, indices, result);
                    }
                } else {
                    Long authId = indices.get(0).getAuthId();
                    List<CardRegister> all = cardRegisterRepository.findByIdGreaterThan(authId);
                    if (all.isEmpty()) {
                        log.info("出租屋门禁开门授权表暂无更新数据无法上传");
                    } else {
                        String result = cardRegisterService.reportData(all);
                        log.info(codeProcess(tableName, result));
                        processIndexByResponse(all, indices, result);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new CronTrigger(authTime).nextExecutionTime(triggerContext);
        });
    }

    /**
     * 出租屋门禁开门记录信息表
     */
    public void uploadRecord() {
        threadPoolTaskScheduler.schedule(new ScheduleRunnable(), triggerContext -> {
            try {
                String tableName = DataType.XQ_MJSKXX.description;
                List<ReportIndex> indices = reportIndexRepository.findAll();
                if (indices.isEmpty() || indices.get(0).getRecordId() == null) {
                    List<Record> all = recordRepository.findAll();
                    if (all.isEmpty()) {
                        log.info("出租屋门禁开门记录信息表暂无数据无法上传");
                    } else {
                        String result = recordService.reportData(all);
                        log.info(codeProcess(tableName, result));
                        processIndexByResponse(all, indices, result);
                    }
                } else {
                    Long recordId = indices.get(0).getRecordId();
                    List<Record> all = recordRepository.findByIdGreaterThan(recordId.toString());
                    if (all.isEmpty()) {
                        log.info("出租屋门禁开门记录信息表暂无更新数据无法上传");
                    } else {
                        String result = recordService.reportData(all);
                        log.info(codeProcess(tableName, result));
                        processIndexByResponse(all, indices, result);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new CronTrigger(recordTime).nextExecutionTime(triggerContext);
        });
    }

    /**
     * 出租屋门禁终端信息表
     */
    public void uploadTerminal() {
        threadPoolTaskScheduler.schedule(new ScheduleRunnable(), triggerContext -> {
            try {
                String tableName = DataType.XQ_MJZD.description;
                List<ReportIndex> indices = reportIndexRepository.findAll();
                if (indices.isEmpty() || indices.get(0).getDeviceId() == null) {
                    List<Device> all = deviceRepository.findAll();
                    if (all.isEmpty()) {
                        log.info("出租屋门禁终端信息表暂无数据无法上传");
                    } else {
                        String result = deviceService.reportData(all);
                        log.info(codeProcess(tableName, result));
                        processIndexByResponse(all, indices, result);
                    }
                } else {
                    Integer deviceId = Integer.valueOf(indices.get(0).getDeviceId().toString());
                    List<Device> all = deviceRepository.findByIdGreaterThan(deviceId);
                    if (all.isEmpty()) {
                        log.info("出租屋门禁终端信息表暂无更新数据无法上传");
                    } else {
                        String result = deviceService.reportData(all);
                        log.info(codeProcess(tableName, result));
                        processIndexByResponse(all, indices, result);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new CronTrigger(terminalTime).nextExecutionTime(triggerContext);
        });
    }

    private <T> void processIndexByResponse(List<T> list, List<ReportIndex> indices, String response) throws Exception {
        ResultDTO resultDTO = JSONObject.parseObject(response, ResultDTO.class);
        String code = resultDTO.getCode();
        if (ResultCode.SUCCESS.code.equals(code)) {
            updateIndex(list, indices);
        }
    }

    private <T> void updateIndex(List<T> list, List<ReportIndex> indices) throws Exception {
        String getId = "getId";
        Class<?> clazz = list.get(list.size() - 1).getClass();
        T t = list.get(list.size() - 1);
        Method method = clazz.getMethod(getId);
        String name = clazz.getName();
        Long id = Long.valueOf(method.invoke(t, null).toString());
        ReportIndex reportIndex;
        if (!indices.isEmpty()) {
            reportIndex = indices.get(0);
        } else {
            reportIndex = new ReportIndex();
        }
        if (Tenant.class.getName().equals(name)) {
            reportIndex.setTenantId(id);
        }
        if (House.class.getName().equals(name)) {
            reportIndex.setHouseId(id);
        }
        if (CardRegister.class.getName().equals(name)) {
            reportIndex.setAuthId(id);
        }
        if (Record.class.getName().equals(name)) {
            reportIndex.setRecordId(id);
        }
        if (Device.class.getName().equals(name)) {
            reportIndex.setDeviceId(id);
        }
        reportIndexRepository.save(reportIndex);
    }

    private String codeProcess(String tableName, String response) {
        ResultDTO resultDTO = JSONObject.parseObject(response, ResultDTO.class);
        String code = resultDTO.getCode();
        if (ResultCode.SYSTEMERR.code.equals(code)) {
            return "平台系统错误";
        }
        if (ResultCode.SUCCESS.code.equals(code)) {
            return tableName + "上报成功";
        }
        if (ResultCode.CHECKNOTPASS.code.equals(code)) {
            return tableName + "数据校验失败!batchNumber(处理序列号):" + resultDTO.getBatchNumber() + "  timestamp(受理时间戳):" + resultDTO.getTimestamp();
        }
        return "未返回";
    }

}
