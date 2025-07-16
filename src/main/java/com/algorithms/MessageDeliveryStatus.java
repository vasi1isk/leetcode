package main.java.com.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageDeliveryStatus {
    public List<Boolean> getDeliveredStatus(List<String> messages, List<Integer> timestamps, int rateLimit) {
        List<Boolean> result = new ArrayList<>();
        Map<String, Integer> lastDeliveryTime = new HashMap<>();
        
        for (int i = 0; i < messages.size(); i++) {
            String message = messages.get(i);
            int currentTime = timestamps.get(i);
            
            // Если сообщение встречается впервые
            if (!lastDeliveryTime.containsKey(message)) {
                result.add(true);
                lastDeliveryTime.put(message, currentTime);
            } else {
                // Проверяем интервал между текущим и предыдущим сообщением
                int timeSinceLastDelivery = currentTime - lastDeliveryTime.get(message);
                boolean isDelivered = timeSinceLastDelivery >= rateLimit;
                result.add(isDelivered);
                
                // Обновляем время последней доставки только если сообщение доставлено
                if (isDelivered) {
                    lastDeliveryTime.put(message, currentTime);
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        MessageDeliveryStatus solution = new MessageDeliveryStatus();
        
        // Тестовые случаи
        List<String> messages = List.of("msg1", "msg2", "msg1", "msg1", "msg2");
        List<Integer> timestamps = List.of(1, 2, 3, 5, 6);
        int rateLimit = 2;
        
        List<Boolean> result = solution.getDeliveredStatus(messages, timestamps, rateLimit);
        
        // Вывод результатов
        System.out.println("Messages: " + messages);
        System.out.println("Timestamps: " + timestamps);
        System.out.println("Rate Limit: " + rateLimit);
        System.out.println("Delivery Status: " + result);
        
        // Ожидаемый результат: [true, true, false, true, true]
        // Объяснение:
        // msg1 (t=1): true (первое вхождение)
        // msg2 (t=2): true (первое вхождение)
        // msg1 (t=3): false (интервал 2 < rateLimit)
        // msg1 (t=5): true (интервал 4 >= rateLimit)
        // msg2 (t=6): true (интервал 4 >= rateLimit)
    }
} 