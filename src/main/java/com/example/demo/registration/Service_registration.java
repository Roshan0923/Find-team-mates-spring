package com.example.demo.registration;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service_registration {
	

		@Autowired
		registration_persistance obj;




	public boolean doRegistration(registration_body obj)
	{
		this.obj.save(obj);
//		byte[] temp_imag = null;
//		try {
//			temp_imag = compressBytes(obj.getPic_byte().getBytes());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		model.setEmail_id(obj.email);
//		model.setName(obj.name);
//		model.setPassword(obj.password);
//		model.setLinkedIn_url(obj.linkedIn_url);
//		model.setDescription(obj.description);
//		model.setLanguage(obj.language);
//		model.setTechnology(obj.technology);
//		model.setPic_byte(temp_imag);
//		
//		System.out.println("image data ");
//		System.out.println(temp_imag);
//		System.out.println("Saving data");
//		registration.save(model);
		//registration.insertData(obj.name,obj.email,obj.password,obj.linkedIn_url,obj.description,obj.language,obj.technology,temp_imag);
		return true;
	}
	
	// compress the image bytes before storing it in the database
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}

}
