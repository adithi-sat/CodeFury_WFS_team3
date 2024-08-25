package org.example.bugtrackingsystem.Dto.DeveloperPage;

public class CloseBugDevResponseDto {

    private int status;
    private String desc;

    public CloseBugDevResponseDto() {
    }

    public CloseBugDevResponseDto(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "CloseBugDevResponseDto{" +
                "status=" + status +
                ", desc='" + desc + '\'' +
                '}';
    }
}
