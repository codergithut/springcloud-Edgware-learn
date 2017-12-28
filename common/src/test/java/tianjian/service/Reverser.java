package tianjian.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Reverser {

    @Autowired
    RemoteService remoteService;

    public String reverseSomeCall() {
        return new StringBuilder(remoteService.someCall()).reverse().toString();
    }
}
