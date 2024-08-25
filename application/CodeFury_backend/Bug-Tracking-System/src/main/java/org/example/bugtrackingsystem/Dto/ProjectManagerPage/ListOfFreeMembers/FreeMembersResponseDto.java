package org.example.bugtrackingsystem.Dto.ProjectManagerPage.ListOfFreeMembers;

import java.util.List;

public class FreeMembersResponseDto {

    private int status;
    private List<Members> freeMembers;

    public FreeMembersResponseDto() {
    }

    public FreeMembersResponseDto(List<Members> freeMembers,int status) {
        this.freeMembers = freeMembers;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Members> getFreeMembers() {
        return freeMembers;
    }

    public void setFreeMembers(List<Members> freeMembers) {
        this.freeMembers = freeMembers;
    }

}
