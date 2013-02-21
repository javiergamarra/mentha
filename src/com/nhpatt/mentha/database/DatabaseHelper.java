package com.nhpatt.mentha.database;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.nhpatt.mentha.R;
import com.nhpatt.mentha.model.Transaction;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	private static final String DATABASE_NAME = "helloAndroid.db";
	private static final int DATABASE_VERSION = 2;

	private RuntimeExceptionDao<Transaction, Integer> transactionDAO = null;

	public DatabaseHelper(final Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION,
				R.raw.ormlite_config);
	}

	@Override
	public void onCreate(final SQLiteDatabase db,
			final ConnectionSource connectionSource) {
		try {
			TableUtils.createTable(connectionSource, Transaction.class);
		} catch (final SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public void onUpgrade(final SQLiteDatabase db,
			final ConnectionSource connectionSource, final int oldVersion,
			final int newVersion) {
		try {
			TableUtils.dropTable(connectionSource, Transaction.class, true);
			onCreate(db, connectionSource);
		} catch (final java.sql.SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
			throw new RuntimeException(e);
		}
	}

	public RuntimeExceptionDao<Transaction, Integer> getTransactionDAO() {
		if (transactionDAO == null) {
			transactionDAO = getRuntimeExceptionDao(Transaction.class);
		}
		return transactionDAO;
	}

	@Override
	public void close() {
		super.close();
		transactionDAO = null;
	}

}
