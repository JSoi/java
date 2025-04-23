package com.practice.design_patterns.behavioral.chain_of_responsibility.deprecated;

@Deprecated
public class DeprecatedRequestHandler {
    public void handleRequest(DeprecatedRequest request) {
        // 인증 단계
        if (!authenticate(request)) {
            System.out.println("인증 실패");
            return;
        }

        // 권한 검사 단계
        if (!checkPermission(request)) {
            System.out.println("권한 없음");
            return;
        }

        // 데이터 유효성 검사 단계
        if (!validateData(request)) {
            System.out.println("데이터 유효성 검사 실패");
            return;
        }

        // 실제 비즈니스 로직 처리
        processRequest(request);
    }

    private boolean authenticate(DeprecatedRequest request) {
        // 단순 예시 (로그인 토큰 유효성 검사 등)
        return request.getToken() != null && request.getToken().equals("valid-token");
    }

    private boolean checkPermission(DeprecatedRequest request) {
        // 단순 예시 (관리자 권한 체크 등)
        return "ADMIN".equals(request.getUserRole());
    }

    private boolean validateData(DeprecatedRequest request) {
        // 단순 예시 (필수 필드 체크 등)
        return request.getData() != null && !request.getData().isEmpty();
    }

    private void processRequest(DeprecatedRequest request) {
        System.out.println("요청 처리 완료: " + request.getData());
    }
}
