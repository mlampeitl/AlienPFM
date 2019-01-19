package net.alientec.pfm.server.controller;

import net.alientec.pfm.data.PfmUser;
import net.alientec.pfm.server.data.PfmDataStore;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PfmUserController {
    @RequestMapping("/users")
    public List<PfmUser> users() throws Exception {
        return PfmDataStore.getPfmUsers();
    }
}
