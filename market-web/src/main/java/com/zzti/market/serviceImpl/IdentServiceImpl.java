package com.zzti.market.serviceImpl;

import com.zzti.market.entity.Ident;
import com.zzti.market.entity.School;
import com.zzti.market.entity.User;
import com.zzti.market.mapper.IdentMapper;
import com.zzti.market.mapper.SchoolMapper;
import com.zzti.market.service.IdentService;
import com.zzti.market.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
public class IdentServiceImpl  implements IdentService {
	@Resource
    IdentMapper identMapper;
	UserService userService;
	@Resource
    SchoolMapper schoolmap;
//	@Override
//	public String InserIdent(String college, String school, String stuId,String stuName,MultipartFile stuphono, HttpServletRequest request,HttpSession session) {
//		User user= (User) session.getAttribute("user");
//		String indpr=UUID.randomUUID().toString().replace("-", "");
//
//		SimpleDateFormat identtime = new SimpleDateFormat("yyyy-MM-dd");
//		School shool=new School();
//		Date time=null;
//
//
//		try {
//			if(identMapper.selectByPrimaryKey(stuId)==null){
//
//				Ident ident=new Ident();
//				 time= identtime.parse(identtime.format(new Date()));
//
//
//
//					//向学校列表中插入数据
//					shool.setUserid(user.getUserId());
//					shool.setSchoolname(school);
//					shool.setCollege(college);
//					int b=schoolmap.insert(shool);
//				String identpic=UUID.randomUUID().toString().replace("-", "");
//				ident.setIdentphoto(identpic);
//				String pname=(stuphono.getOriginalFilename()).substring((stuphono.getOriginalFilename()).lastIndexOf("."));
//				String picname= indpr+pname;
//				StringBuffer sa=request.getRequestURL();
//				String sa2=sa.substring(0,sa.lastIndexOf("/"));
//				String picurl=sa2.substring(0,sa2.lastIndexOf("/"));
//				ident.setRequesturl(picurl+"/picture");
//
//                 String p1 = request.getSession().getServletContext().getRealPath("/index");
//				String p2 = p1.substring(0,p1.lastIndexOf("\\"));
//				String path=p2.substring(0,p2.lastIndexOf("\\"))+"\\picture";
//				ident.setUserid(user.getUserId());
//				ident.setStudentnum(stuId);
//				ident.setIdenttime(time);
//				ident.setUserid(user.getUserId());
//				ident.setIdentid(indpr);
//				ident.setIdentstatus(0);
//				int a= identMapper.insert(ident);
//                try {
//
//	                stuphono.transferTo(new File(path+"\\"+picname));
//				} catch (IllegalStateException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//
//			//向认证表中插入数据
//
//			if(a==1 && b==1){
//
//
//			     return "0";
//
//
//			}else{
//
//				return "1";
//
//
//			}
//			}else{return "2";
//
//			}
//
//		} catch (ParseException  e) {
//
//		   e.printStackTrace();
//		   return "1";
//		}
//
//
//	}
//
//
//
//
//	@Override
//	public List<Ident> selectLimitLengthIs10(int i) {
//		return identMapper.selectLimitLengthIs10(i);
//	}
//	@Override
//	public int querycowntall() {
//		// TODO Auto-generated method stub
//		return identMapper.querycowntall();
//	}
//
//
//
//
//	@Override
//	public List<Ident> selectLimitLengthIs101(int i, int j) {
//
//		return identMapper.selectLimitLengthIs101(i,j);
//	}
//
//
//
//
//	@Override
//	public int querycowntall1(int i) {
//
//		return identMapper.querycowntall1(i);
//	}
//
//
//
//
//	@Override
//	public List<Ident> selectLimitLengthIs102(int i,String search) {
//		// TODO Auto-generated method stub
//		return identMapper.selectLimitLengthIs102(search,i);
//	}
//
//
//
//
//	@Override
//	public int querycowntall2(String search) {
//		// TODO Auto-generated method stub
//		return identMapper.querycowntall2(search);
//	}
//
//
//
//
//	@Override
//	public int updentstud(String identid, int i) {
//		Ident idt=identMapper.selectByPrimaryKey(identid);
//		idt.setIdentstatus(i);
//		return identMapper.updateByPrimaryKey(idt);
//	}

}
