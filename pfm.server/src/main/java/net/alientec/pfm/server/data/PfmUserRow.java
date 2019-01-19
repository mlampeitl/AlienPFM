package net.alientec.pfm.server.data;

import java.util.UUID;

public class PfmUserRow {
    private PfmRowStatus rowStatus = PfmRowStatus.Unknown;

    protected static PfmUserRow fromDb(UUID userId, String username) {
        PfmUserRow row = new PfmUserRow();
        row.userId = userId;
        row.userIdIsNull = (userId == null);
        row.username = username;
        row.usernameIsNull = (username.isEmpty());
        row.rowStatus = PfmRowStatus.FromDB;
        return row;
    }

    public PfmUserRow(){ }

    private UUID userId = null;
    private Boolean userIdIsNull = true;
    private Boolean userIdHasChanged = false;

    protected UUID getUserId() {
        return userId;
    }
    public void setUserId(UUID userId) {
        if(userId == null) {
            if (!userIdIsNull) {
                this.userId = null;
                this.userIdIsNull = true;
                this.userIdHasChanged = true;
                this.rowStatus = PfmRowStatus.Changed;
            } else {
                if (!userId.equals(this.userId)) {
                    this.userId = userId;
                    this.userIdIsNull = false;
                    this.userIdHasChanged = true;
                    this.rowStatus = PfmRowStatus.Changed;
                }
            }
        }
    }

    private String username = null;
    private Boolean usernameIsNull = true;
    private Boolean usernameHasChanged = false;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if(username.isEmpty()) {
            if(! usernameIsNull) {
                this.username = null;
                this.usernameIsNull = true;
                this.usernameHasChanged = true;
                this.rowStatus = PfmRowStatus.Changed;
            }
            else {
                if(!username.equals(this.username)){
                    this.username = username;
                    this.usernameIsNull = false;
                    this.usernameHasChanged = true;
                    this.rowStatus = PfmRowStatus.Changed;
                }
            }
        }
    }

}
