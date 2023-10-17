package homework.myspring.di.strategy1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import homework.myspring.di.strategy1.dao.UserDao;
import myspring.user.vo.UserVO;

public class UserServiceImpl implements UserService {

	UserDao userdao;
	
	public UserServiceImpl() {
		System.out.println(this.getClass().getName() + " 생성자 호출됨!!");
	}
	
	public UserServiceImpl(UserDao userdao) {
		System.out.println(this.getClass().getName() + "오버로딩 된 생성자 호출됨!!");
		this.userdao = userdao;
	}

	public void setDaoImpl(UserDao userdao) {
		System.out.println("Hello setUserDao() >> " + userdao);
		this.userdao = userdao;
	}

	//
	public List<UserVO> getUserList() {
		return userdao.readAll();
	}
	
	//
	@Override
	public UserVO getUser(int index) {
		return userdao.read(index);
	}
}
