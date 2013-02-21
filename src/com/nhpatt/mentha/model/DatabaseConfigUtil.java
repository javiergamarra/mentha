package com.nhpatt.mentha.model;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

public class DatabaseConfigUtil extends OrmLiteConfigUtil {

	private static final Class<?>[] classes = new Class[] { Category.class,
			Transaction.class, };

	public static void main(final String[] args) throws Exception {
		writeConfigFile("ormlite_config.txt", classes);
	}
}
