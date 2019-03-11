package Lottery;

import java.util.HashMap;
import java.util.Map;

class PointService {
    private Map<Long, Long> pointRepository = new HashMap<>();

    Long getUserPoint(Long userId) {
        return pointRepository.get(userId);
    }

    void deposit(Long userId, Long point) {
        pointRepository.put(userId, point);
    }

    void withdraw(Long userId, Long point) {
        Long previousPoint = getUserPoint(userId);

        if (previousPoint < point) {
            throw new RuntimeException("cannot withdraw more than user has");
        }

        pointRepository.put(userId, previousPoint - point);
    }
}
