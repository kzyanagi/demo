/*
 * APOLO System
 * (C) Copyright YKK AP Japan, Ltd. 2010. All Rights Reserved.
 */

package com.ibm.demo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/**
 * ファイル出力時、1ファイルに対して1要素を出力する。
 * @author IBM
 * @version
 * @since
 */

public class FileListMultipleImpl<E> extends FileListImpl<E> {

	File deleteFile ;
	/**
	 * コンストラクタ
	 *
	 * @param path：オブジェクト出力用のフォルダ（Fileオブジェクト）
	 *
	 * @return
	 * @throws
	 */
	FileListMultipleImpl(String path) {
		super(path);

	}
	/**
	 * リストの最後に、指定された要素をリストの最後に追加します
	 *
	 * @param E arg　：リストに追加される要素
	 *         　　　
	 * @return boolean　:　この呼び出しの結果、このコレクションが変更された場合は true
	 * 　　　　
	 * @throws
	 *  NullPointerException - 指定された要素が null で、このリストが null 要素をサポートしない場合
	 *  IllegalArgumentException - この要素の特性が原因で、このリストに追加できない場合
	 */
	@Override
	public boolean add(E arg0) {
		int intMaxCount = fileObjectList.size();
		this.add(intMaxCount, arg0);
		return true;
	}

	/**
	 * リスト内の指定された位置に、指定された要素を挿入します (任意のオペレーション)。
	 * 現在その位置にある要素と後続の要素は右に移動します (インデックス値に 1 を加算)。
	 *
	 * @param index - 指定された要素が挿入されるインデックス
	 *         element - 挿入される要素
	 * @return
	 * @throws
	 *
     *     NullPointerException - 指定された要素が null で、このリストが null 要素をサポートしない場合
     *     IllegalArgumentException - この要素の一部の特性のために、リストに要素を追加できない場合
	 */
	@Override
	public void add(int arg0, E arg1) {
		if (arg1 == null){
			throw new NullPointerException ("nullはaddできません。");
		}else if(arg1 instanceof Serializable == false){
			throw new IllegalArgumentException("Serializableされていないオブジェクトは追加できません。");
		}
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream out;
		FileOutputStream output = null;
		try {
			out = new ObjectOutputStream(bout);
			out.writeObject(arg1);
			out.close();
			byte[] bytes = bout.toByteArray();

			int objectLength = bytes.length;

			File deleteFile = new File(this.path+this.uid);
			if(!deleteFile.exists()){
				deleteFile.mkdir();
			}
			output = new FileOutputStream(deleteFile.getAbsolutePath() + "\\" + fileObjectList.size() + ".txt" , true);

			output.write(bytes, 0, objectLength);
			int offset;
			if (fileObjectList.isEmpty()) {
				maxItemNo = 0;
				offset = 0;
			} else {
				Pair lastPair = fileObjectList.get(maxItemNo - 1);
				offset = lastPair.getLength() + lastPair.getOffset();
			}

			String currentPairFileName= fileObjectList.size() + ".txt";
			Pair currentPair = new Pair(offset, objectLength , currentPairFileName);
			maxItemNo++;
			fileObjectList.add(arg0, currentPair);

		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	/**
	 * リスト内の指定された位置にある要素を返します。
	 *
	 * @param index - 返される要素のインデックス
	 *
	 * @return リスト内の指定された位置にある要素
	 * @throws
	 * 　　　　　IndexOutOfBoundsException - インデックスが範囲外の場合 (index < 0 || index >= size())
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E get(int arg0) {
		if(arg0 < 0 || arg0 >= fileObjectList.size()){
			throw new IndexOutOfBoundsException("インデックスが範囲外です");
		}
		Object copy = null;
		FileInputStream input = null;
		ByteArrayInputStream bais = null;
		ObjectInputStream os = null;
		try {
			Pair currentPair = fileObjectList.get(arg0);

			String inputfile = this.path+this.uid + "\\" + currentPair.getFilename();
			input = new FileInputStream(inputfile);

			byte[] bytes = new byte[currentPair.getLength()];

			input.read(bytes, 0, currentPair.getLength());

			// バイト配列から、オブジェクトを複合化
			bais = new ByteArrayInputStream(bytes);
			os = new ObjectInputStream(bais);

			copy = os.readObject();

			return (E) copy;

		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				os.close();
				bais.close();
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * リストからすべての要素を削除します。この呼び出しが戻ると、このリストは空になります。
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 * 　　
	 */
	@Override
	public void clear() {

		fileObjectList.clear();


		try {
			File f = new File(this.path+this.uid + "\\");
			File[] files=f.listFiles();
			if (files!=null){
				for(int i=0; i<files.length; i++){
					if (files[i].exists()){
						files[i].delete();
					}
				}
			}
			f.delete();
		} catch (Exception e) {
			e.printStackTrace();
			//throw new RuntimeException(e);
		}
	}

}
