public class Singletion {
	private volatile static Singletion mSingletion;
	

	public static Singletion getInstence() {

		if (mSingletion != null) {
			synchronized (Singletion.class) {
				if (mSingletion == null) {
					mSingletion = new Singletion();
				}
			}
		}
		return mSingletion;
	}

}
