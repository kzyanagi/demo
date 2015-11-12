package com.ibm.demo;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;
import java.util.UUID;
/**
 * 順序付けられたコレクションです。
 * LIST から実装しているクラスです。
 * 要素にアクセスするための ８ つのメソッドを提供します。
 * 格納した要素は、メモリではなく、ファイルへ出力されます。
 * @author
 * @version 1.0
 */
public abstract class FileListImpl<E> implements List<E> {

	protected String path;
	protected String filename;
	protected String uid;
	protected int maxItemNo;


	// ファイルに格納したオブジェクトの位置と、長さを示す情報を管理
	protected List<Pair> fileObjectList = new ArrayList<Pair>();

	public List<Pair> getFileObjectList() {
		return fileObjectList;
	}

	public void setFileObjectList(List<Pair> fileObjectList) {
		this.fileObjectList = fileObjectList;
	}


	/**
	 * コンストラクタ
	 *
	 * @param path：オブジェクト出力用のフォルダ（Fileオブジェクト）
	 *
	 * @return
	 * @throws
	 */
	FileListImpl(String path) {
		this.path = path;
		this.uid = UUID.randomUUID().toString();
		this.filename = path + "FileListImpl_" + this.uid + ".txt";
		File deleteFile = new File(this.path);
		String[] children = deleteFile.list();
		String deleteperiod;
		String deleteFLG;
		try {
			//インスタンス作成時のファイルの削除期間（日)
			deleteperiod = loadUtf8Properties("").getProperty("deleteperiod");
			//インスタンス作成時のファイルの削除実施フラグ
			deleteFLG = loadUtf8Properties("").getProperty("deleteFLG");
			//本日日付
			Date now = new Date();
			//削除基準日の決定
			Date deleteday = new Date(now.getTime()-((Integer.parseInt(deleteperiod))*24*60*60*1000L));
			//ディレクトリにあるすべてのファイルを処理する
			if (children==null){
				return;
			}
			for (int i=0; i<children.length; i++) {
				if(children[i].length() >=12 ){
					String prefixFilename =children[i].substring(0,12);
					if(prefixFilename.equals("FileListImpl")){
						File childrenFile = new File(deleteFile,children[i]);
						Date lastModified = new Date(childrenFile.lastModified());
						//削除基準日以前のファイル更新日付だった場合は、ファイルを削除する。
						if(deleteFLG.equals("ON") && deleteday.after(lastModified)==true){
							childrenFile.delete();
						}
					}
				}
			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
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
	
	public abstract boolean add(E arg0) ;

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
	
	public abstract void add(int arg0, E arg1);
	/**
	 * 未実装
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 * 　UnsupportedOperationException - このメソッドが呼び出された場合、次のメッセージを戻す。"メソッドaddAll(Collection<? extends E> arg0)は実装されていません。"
	 */
	
	public boolean addAll(Collection<? extends E> arg0) {
//		int intCount = fileObjectList.size();
//		this.addAll(intCount, arg0);
//		return true;
		throw new UnsupportedOperationException("メソッドaddAll(Collection<? extends E> arg0)は実装されていません。");
	}

	/**
	 * 未実装
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 * 　UnsupportedOperationException - このメソッドが呼び出された場合、次のメッセージを戻す。"メソッドaddAll(int arg0, Collection<? extends E> arg1)は実装されていません。"
	 */
	
	public boolean addAll(int arg0, Collection<? extends E> arg1) {
//		Iterator it = arg1.iterator();
//
//		int intCount = arg0;
//
//		while (it.hasNext()) {
//			this.add(intCount, (E) it.next());
//			intCount++;
//		}
//
//		return true;
		throw new UnsupportedOperationException("メソッドaddAll(int arg0, Collection<? extends E> arg1)は実装されていません。");
	}

	/**
	 * リストからすべての要素を削除します。この呼び出しが戻ると、このリストは空になります。
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 * 　UnsupportedOperationException - このメソッドが呼び出された場合、次のメッセージを戻す。"メソッドcontains(Object arg0)は実装されていません。" 　　
	 */
	
	public abstract void clear();

	/**
	 * 未実装
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 * 　UnsupportedOperationException - このメソッドが呼び出された場合、次のメッセージを戻す。"メソッドcontains(Object arg0)は実装されていません。"
	 */
	
	public boolean contains(Object arg0) {
		throw new UnsupportedOperationException("メソッドcontains(Object arg0)は実装されていません。");
	}

	/**
	 * 未実装
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 * 　UnsupportedOperationException - このメソッドが呼び出された場合、次のメッセージを戻す。"メソッドcontainsAll(Collection<?> arg0)は実装されていません。"
	 */
	
	public boolean containsAll(Collection<?> arg0) {
		throw new UnsupportedOperationException(
				"メソッドcontainsAll(Collection<?> arg0)は実装されていません。");
	}

	/**
	 * リスト内の指定された位置にある要素を返します。
	 *
	 * @param index - 返される要素のインデックス
	 *
	 * @return リスト内の指定された位置にある要素
	 * @throws
	 * 　UnsupportedOperationException - このメソッドが呼び出された場合、次のメッセージを戻す。"メソッドE get(int arg0)は実装されていません。"
	 */
	
	public abstract E get(int arg0);
	/**
	 * 未実装
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 * 	 UnsupportedOperationException - このメソッドが呼び出された場合、次のメッセージを戻す。"メソッドindexOf(Object arg0)は実装されていません。"
	 */
	
	public int indexOf(Object arg0) {
		throw new UnsupportedOperationException(
				"メソッドindexOf(Object arg0)は実装されていません。");
	}

	/**
	 * リストに要素がない場合に true を返します。
	 *
	 * @param
	 *
	 * @return リストが要素を 1 つも保持していない場合は true
	 * @throws
	 */
	
	public boolean isEmpty() {
		if (fileObjectList.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * このリスト内の要素を適切な順序で繰り返し処理する反復子を返します。
	 *
	 * @param
	 *
	 * @return リスト内の要素を適切な順序で繰り返し処理する反復子
	 * @throws
	 */
	
	public Iterator<E> iterator() {
		Iterator<E> itr = new FileListImplIterator<E>(this);
		return itr;
	}

	/**
	 * 未実装
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 * 	 UnsupportedOperationException - このメソッドが呼び出された場合、次のメッセージを戻す。"メソッドlastIndexOf(Object arg0)は実装されていません。"
	 */
	
	public int lastIndexOf(Object arg0) {
		throw new UnsupportedOperationException(
				"メソッドlastIndexOf(Object arg0)は実装されていません。");
	}

	/**
	 * 未実装
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 * 	 UnsupportedOperationException - このメソッドが呼び出された場合、次のメッセージを戻す。"メソッドlistIterator()は実装されていません。"
	 */
	
	public ListIterator<E> listIterator() {
		throw new UnsupportedOperationException("メソッドlistIterator()は実装されていません。");
	}

	/**
	 * 未実装
	 *
	 * @param
	 *
	 * @return
	 * @throws
 	 * 	 UnsupportedOperationException - このメソッドが呼び出された場合、次のメッセージを戻す。"メソッドlistIterator(int arg0)は実装されていません。"
	 */
	
	public ListIterator<E> listIterator(int arg0) {

		throw new UnsupportedOperationException("メソッドlistIterator(int arg0)は実装されていません。");
	}

	/**
	 * 未実装
	 *
	 * @param
	 *
	 * @return
	 * @throws
  	 * 	 UnsupportedOperationException - このメソッドが呼び出された場合、次のメッセージを戻す。"メソッドremove(Object arg0)は実装されていません。"
	 */
	
	public boolean remove(Object arg0) {

		throw new UnsupportedOperationException(
				"メソッドremove(Object arg0)は実装されていません。");
	}

	/**
	 * リスト内の指定された位置にある要素を削除します (任意のオペレーション)。
	 * 後続の要素は左に移動します (インデックス値から 1 を減算)。リストから削除された要素が返されます。
	 *
	 * @param index - 削除される要素のインデックス
	 *
	 * @return 指定された位置に以前あった要素
	 * @throws
	 * IndexOutOfBoundsException - インデックスが範囲外の場合 (index < 0 || index >= size())
	 */
	
	public E remove(int arg0) {
		if(arg0 < 0 || arg0 >= fileObjectList.size()){
			throw new IndexOutOfBoundsException("インデックスが範囲外です");
		}
		//戻り値のセット
		E objReturn = this.get(arg0);

		//要素の削除
		Pair currentPair = fileObjectList.get(arg0);
		fileObjectList.remove(currentPair);

		//削除された要素を戻す。
		return (E) objReturn;
	}

	/**
	 * 未実装
	 *
	 * @param
	 *
	 * @return
	 * @throws
   	 * 	 UnsupportedOperationException - このメソッドが呼び出された場合、次のメッセージを戻す。"メソッドremoveAll(Collection<?> arg0)は実装されていません。"
	 */
	
	public boolean removeAll(Collection<?> arg0) {

		throw new UnsupportedOperationException(
				"メソッドremoveAll(Collection<?> arg0)は実装されていません。");
	}

	/**
	 * 未実装
	 *
	 * @param
	 *
	 * @return
	 * @throws
   	 * 	 UnsupportedOperationException - このメソッドが呼び出された場合、次のメッセージを戻す。"メソッドretainAll(Collection<?> arg0)は実装されていません。"
	 */
	
	public boolean retainAll(Collection<?> arg0) {

		throw new UnsupportedOperationException(
				"メソッドretainAll(Collection<?> arg0)は実装されていません。");
	}

	/**
	 * 未実装
	 *
	 * @param
	 *
	 * @return
	 * @throws
   	 * 	 UnsupportedOperationException - このメソッドが呼び出された場合、次のメッセージを戻す。"メソッドset(int arg0, E arg1)は実装されていません。"
	 */
	
	public E set(int arg0, E arg1) {

		throw new UnsupportedOperationException(
				"メソッドset(int arg0, E arg1)は実装されていません。");
	}

	/**
	 * リスト内にある要素の数を返します。
	 *
	 * @param
	 *
	 * @return リスト内の要素数
	 * @throws
	 *
	 */
	
	public int size() {
		int intCnt = 0;
		intCnt = fileObjectList.size();
		return intCnt;
	}

	/**
	 * 未実装
	 *
	 * @param
	 *
	 * @return
	 * @throws
   	 * 	 UnsupportedOperationException - このメソッドが呼び出された場合、次のメッセージを戻す。"メソッドsubList(int arg0, int arg1)は実装されていません。"
	 */
	
	public List<E> subList(int arg0, int arg1) {

		throw new UnsupportedOperationException(
				"メソッドsubList(int arg0, int arg1)は実装されていません。");
	}

	/**
	 * 未実装
	 *
	 * @param
	 *
	 * @return
	 * @throws
   	 * 	 UnsupportedOperationException - このメソッドが呼び出された場合、次のメッセージを戻す。"メソッドtoArray()は実装されていません。"
	 */
	
	public Object[] toArray() {

		throw new UnsupportedOperationException("メソッドtoArray()は実装されていません。");
	}

	/**
	 * 未実装
	 *
	 * @param
	 *
	 * @return
	 * @throws
   	 * 	 UnsupportedOperationException - このメソッドが呼び出された場合、次のメッセージを戻す。"メソッドremoveAll(Collection<?> arg0)は実装されていません。"
	 */
	
	public <T> T[] toArray(T[] arg0) {

		throw new UnsupportedOperationException(
				"メソッドremoveAll(Collection<?> arg0)は実装されていません。");
	}

	/**
	 * ObjectList用のクラス
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */
	protected class Pair {
		private int offset;
		private int length;
		private String filename;


		public Pair(int offset1, int objectLength) {
			this.offset = offset1;
			this.length = objectLength;
		}

		public Pair(int offset1, int objectLength , String filename) {
			this.offset = offset1;
			this.length = objectLength;
			this.filename = filename;
		}

		public int getOffset() {
			return offset;
		}

		public void setOfffset(int offset) {
			this.offset = offset;
		}

		public int getLength() {
			return length;
		}

		public void setLength(int length) {
			this.length = length;
		}

		public String getFilename() {
			return filename;
		}

		public void setFilename(String filename) {
			this.filename = filename;
		}
	}

	private  Properties loadUtf8Properties(String path) throws IOException {
	    Properties prop = new Properties();
	    InputStream inputStream = this.getClass().getResourceAsStream("/listFactory.properties");

	    prop.load(inputStream);
	    return prop;
	}

}
