package module_admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.module_core.User;

@Mapper
public interface UserMapper {
	
//	@Select("select * from user limit 1")
//	public User getData();
	
	@Mapper
	public User getData();
	
	@Mapper
	public int getCount();
}
