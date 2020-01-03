package com.example.helloworld.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.MongoDbFactory;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.gridfs.GridFsResource;
//import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.example.helloworld.entity.User;
//import com.example.helloworld.repository.UserRepository;
import com.example.helloworld.service.CustomerService;
//import com.mongodb.client.gridfs.GridFSBucket;
//import com.mongodb.client.gridfs.GridFSBuckets;
//import com.mongodb.client.gridfs.GridFSDownloadStream;
//import com.mongodb.client.gridfs.model.GridFSFile;

@RestController
public class HelloController {
	private final static Logger logger = LoggerFactory.getLogger(HelloController.class);

	@Autowired
	private RedisTemplate<String, Map<String, Object>> redisTemplate;

	@Autowired
	private CustomerService customerService;
	
	// @Autowired
	// private UserRepository userRepository;
	//
	// @Autowired
	// private MongoDbFactory mongoDbFactory;
	//
	// @Autowired
	// private GridFsTemplate gridFsTemplate;

	@RequestMapping("/hello")
	public String getHello(HttpServletRequest httpRequest) {
		String auth = httpRequest.getHeader("Authorization");
		logger.info(auth);
		return "Hello World";
		
	}

	@RequestMapping("/redis")
	public String getRedis() {
		try {
			Map<String, Object> testMap = new HashMap<String, Object>();
			Map<String, Object> testMap2 = new HashMap<String, Object>();
			testMap2.put("test2", "mike");
			testMap.put("name", "jack");
			testMap.put("age", 27);
			testMap.put("class", "1");
			testMap.put("in", testMap2);
			redisTemplate.opsForHash().putAll("redishash", testMap);
			logger.info(redisTemplate.opsForHash().entries("redishash").toString());
			logger.info(redisTemplate.opsForHash().get("redishash", "age").toString());
			return String.valueOf(redisTemplate.opsForValue().increment("SSOsessionId", 1L));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "empty";
	}

	@RequestMapping("/mybatis")
	public String getCustomer() {

		return customerService.insertCustomer();
	}
		
	// @RequestMapping("/mongodb/getAll")
	// public List<User> getAllUser() {
	// List<User> userList = userRepository.findAll();
	// return userList;
	// }
	//
	// @RequestMapping("/mongodb/savePic")
	// public String savePic() throws FileNotFoundException {
	// File file = new File("D:/test.png");
	// // 定义输入流
	// FileInputStream inputStram = new FileInputStream(file);
	// // 向GridFS存储文件
	// ObjectId objectId = gridFsTemplate.store(inputStram, file.getName(), "");
	// // 得到文件ID
	// String fileId = objectId.toString();
	//
	// return fileId;
	// }

	// private byte[] getBytes(InputStream inputStream) throws Exception {
	// ByteArrayOutputStream bos = new ByteArrayOutputStream();
	// byte[] b = new byte[1024];
	// int i = 0;
	// while (-1 != (i = inputStream.read(b))) {
	// bos.write(b, 0, i);
	// }
	// return bos.toByteArray();
	// }

	// @RequestMapping(value = "/mongodb/show")
	// public void show(HttpServletRequest request, HttpServletResponse response) {
	// try {
	// OutputStream out = response.getOutputStream();
	// response.setContentType("image/jpg");
	//
	// GridFSFile file = gridFsTemplate
	// .findOne(new Query().addCriteria(Criteria.where("filename").is("test.png")));
	//
	// GridFSBucket bucket = GridFSBuckets.create(mongoDbFactory.getDb());
	// GridFSDownloadStream gridFSDownloadStream =
	// bucket.openDownloadStream(file.getObjectId());
	//
	// GridFsResource resource = new GridFsResource(file, gridFSDownloadStream);
	//
	// InputStream inputStream = resource.getInputStream();
	// byte[] f = getBytes(inputStream);
	//
	// out.write(f);
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
}
