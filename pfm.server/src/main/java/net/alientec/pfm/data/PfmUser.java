package net.alientec.pfm.data;

import java.util.UUID;

public class PfmUser {

    /*
     * Properties
     */
    private UUID userId;
    public UUID getUserId() {
        return userId;
    }
    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    private String username;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
