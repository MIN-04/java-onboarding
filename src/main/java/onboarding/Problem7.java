package onboarding;

import java.util.*;

public class Problem7 {
    /**
     * 기능 구현
     * 1. user와 이미 친구인 사람을 찾기
     * 2. user의 친구와 친구인 사람을 찾기
     * 3. 사용자와 함께 아는 친구 점수
     * 4. 사용자의 타임 라인에 방문한 횟수
     * 5. 결과값 정렬, 5개 제한
     */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        // user와 이미 친구인 사람을 찾는 로직
        List<String> alreadyFriends = new ArrayList<>();
        for (List<String> friend : friends) {
            if (friend.get(1).equals(user)) {
                alreadyFriends.add(friend.get(0));
            }
        }

        // user의 친구와 친구인 사람을 찾는 로직
        List<String> newFriends = new ArrayList<>();
        for (String alFriend : alreadyFriends) {
            for (List<String> friend : friends) {
                if (alFriend.equals(friend.get(0)) && !friend.get(1).equals(user)) {
                    newFriends.add(friend.get(1));
                }
            }
        }

        // 점수를 담을 Map 객체 생성 (10점)
        Map<String, Integer> scoreMap = new HashMap<>();
        for (String name : newFriends) {
            if (!scoreMap.containsKey(name)) {
                scoreMap.put(name, 10);
            }else {
                int score = scoreMap.get(name) + 10;
                scoreMap.replace(name, score);
            }
        }

        return answer;
    }
}
