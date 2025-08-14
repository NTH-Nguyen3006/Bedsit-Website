package com.example.ahihi.sevices;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.example.ahihi.entities.Contract;

import com.example.ahihi.repository.ContractRepository;

// @Service
public class SchedulerService {
    @Autowired
    private ContractRepository contractRepository;

    // @Autowired
    // private SendMailService mailService;

    @Scheduled(cron = "0 0 8 * * *")
    public void checkAndSendPaymentReminders() {
        System.out.println("Bắt đầu quét các hợp đồng sắp đến hạn...");
        LocalDate today = LocalDate.now();
        // Lấy danh sách các hợp đồng cần gửi thông báo
        // LocalDate reminderDate = today.plusDays(5);

        // List<Contract> contractsToNotify = contractRepository
        // .findAllByNextPaymentDateIsBeforeOrEqualAndNextPaymentDateIsAfterOrEqual(reminderDate,
        // today);

        // for (Contract contract : contractsToNotify) {
        // if (contract.getLastNotificationSentDate() == null ||
        // contract.getLastNotificationSentDate()
        // .isBefore(contract.getNextPaymentDate().minusMonths(contract.getPaymentCycleInMonths())))
        // {
        // // Gửi thông báo
        // mailService.sendMail("Đến Đóng Tiền Thuê Trọ", null);

        // // Cập nhật lại ngày gửi thông báo
        // contract.setLastNotificationSentDate(today);
        // contractRepository.save(contract);
        // System.out.println("Đã gửi thông báo cho hợp đồng ID: " + contract.getId());
        // }
        // }
        System.out.println("Hoàn tất quét.");
    }
}
