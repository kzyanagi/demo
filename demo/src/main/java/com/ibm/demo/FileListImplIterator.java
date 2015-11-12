package com.ibm.demo;

import java.util.Iterator;
import java.util.List;

/**
 *
 * コレクションの反復子です。
 * Iteratorから実装されているクラスです。
 * FileImplクラス用のクラスとして作成されています。
 *
 * @author
 * @version 1.0
 */
public class FileListImplIterator<E> implements Iterator<E> {

	private FileListImpl<?> lst = null;
	private int currentint ;

	/**
	 * コンストラクタ
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */
	public FileListImplIterator(FileListImpl<E> fileListImpl) {
		this.lst = fileListImpl;
		this.currentint = 0;
	}


	/**
	 * 繰り返し処理でさらに要素がある場合に true を返します。
	 * つまり、next が例外をスローしないで要素を返す場合に true を返します。
	 *
	 * @param
	 *
	 * @return 反復子がさらに要素を持つ場合は true
	 * @throws
	 */
	
	public boolean hasNext() {
		List<?> lst2 = lst.getFileObjectList();
		if(currentint < lst2.size()){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 繰り返し処理で次の要素を返します。
	 * hasNext() メソッドが false を返すまでこのメソッドを繰り返し呼び出すと、
	 * 基になるコレクション内の各要素が一度だけ返されます。
	 *
	 * @param
	 *
	 * @return 繰り返し処理で次の要素
	 * @throws　NoSuchElementException - 繰り返し処理でそれ以上要素がない場合
	 */

	@SuppressWarnings("unchecked")
	
	public E next() {
		E obj = (E) lst.get(currentint);
		currentint++;
		return (E) obj;

	}

	/**
	 * 基になるコレクションから、反復子によって最後に返された要素を削除します (任意のオペレーション)。
	 * このメソッドは、next の呼び出しごとに 1 回だけ呼び出すことができます。
	 * 反復子の動作は、繰り返し処理がこのメソッドの呼び出し以外の方法で実行されているときに
	 * 基になるコレクションが変更された場合は保証されません。
	 *
	 * @param
	 *
	 * @return 繰り返し処理で次の要素
	 * @throws UnsupportedOperationException - Iterator が remove オペレーションをサポートしない場合
	 * 　　　　 IllegalStateException - next メソッドがまだ呼び出されていないか、next メソッドの最後の呼び出しのあとに remove メソッドがすでに呼び出されている場合
	 */
	
	public void remove() {
		lst.remove(currentint);
	}

}
