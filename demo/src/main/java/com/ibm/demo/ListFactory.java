/*
 * APOLO System
 * (C) Copyright YKK AP Japan, Ltd. 2010. All Rights Reserved.
 */

package com.ibm.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/** プロパティファイルを参照し、設定内容により、AllayListオブジェクトかFilelistオブジェクトの
 *  どちらかを戻す。
 *
 *  戻り値は、プロパティファイルに指定がない場合、FileListを戻すようにする。
 *
 *  FileListオブジェクトの出力先パスは、プロパティファイルに指定がない場合、環境変数の%TEMP%へ出力する。
 * @author ISCJ
 * @version
 * @since
 */

public class ListFactory<E> {

	//モード（ArrayListを戻すか、Filelistを戻すか)
	private String mode;

	//タイプ（Filelistを作成する場合のタイプ FileListSingleImplの場合:0、FileListMultipleImplの場合:1)
	private String type;

	//パス（Filelistを作成する場合の出力先パス)
	private String path;



	//定数
	//モード（Filelist:0、Arraylist:1)
	private final String ARRAYLIST_MODE = "1";

	//Filelistのタイプ（FileListSingleImplの場合:0、FileListMultipleImplの場合:1)
	private final String FILELIST_TYPE_MULTI = "1";

	//戻り値用
	private List<E> listFactoryList= null;


	/**
	 * ArrayList、Filelistのいずれかの、インスタンスを作成し返す。
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 * 　　
	 */
	public List<E> createList(){
		try {
			//モードの取得
			this.mode = loadUtf8Properties("").getProperty("mode");
			//項目が取得できなかった場合は、から文字を設定
			if(this.mode == null){this.mode = "";}

			//タイプの取得
			this.type = loadUtf8Properties("").getProperty("type");
			//項目が取得できなかった場合は、から文字を設定
			if(this.type == null){this.type = "";}

			//出力先パスの取得
			this.path = loadUtf8Properties("").getProperty("path");
			//項目が取得できなかった場合は、から文字を設定
			if(this.path == null  ){this.path = System.getenv("TEMP") + "\\";}

		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("プロパティファイルのデータ取得に失敗しました。");
		}

		//ArrayListのインスタンスを作成
		if(mode.equals(ARRAYLIST_MODE)){
		    this.listFactoryList = new ArrayList<E>();
		}else{
			if(type.equals(FILELIST_TYPE_MULTI)){
				//FileListMultipleImplのインスタンスを作成
				this.listFactoryList = new FileListMultipleImpl<E>(path);
			}else{
				//FileListSingleImplのインスタンスを作成
				this.listFactoryList = new FileListSingleImpl<E>(path);
			}

		}

		return this.listFactoryList;

	}

	private Properties loadUtf8Properties(String path) throws IOException {
	    Properties prop = new Properties();
	    InputStream inputStream = this.getClass().getResourceAsStream("/listFactory.properties");

	    prop.load(inputStream);	    prop.load(inputStream);
	    return prop;
	}

}
