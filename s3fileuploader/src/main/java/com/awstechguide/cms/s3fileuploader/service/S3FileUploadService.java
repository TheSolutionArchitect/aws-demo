package com.awstechguide.cms.s3fileuploader.service;

import org.springframework.web.multipart.MultipartFile;

public interface S3FileUploadService {

	String uploadFile(MultipartFile file);

	byte[] downloadFile(String fileName);

	String deleteFile(String fileName);

}
