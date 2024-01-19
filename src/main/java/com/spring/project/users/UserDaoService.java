package com.spring.project.users;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    private static List<Users> al=new ArrayList<>();
    private static int UsersC=0;
    static{
        al.add(new Users(++UsersC,"Sai", LocalDate.now().minusYears(15)));
        al.add(new Users(++UsersC,"Datta", LocalDate.now().minusYears(16)));
        al.add(new Users(++UsersC,"Viswas", LocalDate.now().minusYears(17)));
    }
    public List<Users> findAll(){
        return al;
    }

    public Users findSpecific(int id) {
        for (Users i:al  ) {
            if(i.getId()==id) return i;
        }
        return null;
    }

    public Users AddUser(Users user) {

        user.setId(++UsersC);
        al.add(user);
        return user;
    }

    public void deleteSpecific(int id) {
        int idx=-1;
        for(int i=0;i<al.size();i++){
            if(al.get(i).getId()==id){
                idx =i;break;
            }
        }
        if(idx!=-1) al.remove(idx);
    }
}
