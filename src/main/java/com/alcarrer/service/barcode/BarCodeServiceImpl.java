package com.alcarrer.service.barcode;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.alcarrer.model.Produto;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

@Service
public class BarCodeServiceImpl implements BarCodeService {

	@Override
	public Produto encode(String barCode128) {

		return null;
	}

	@Override
	public Produto decode(String barCode128) {

		return null;
	}


}
