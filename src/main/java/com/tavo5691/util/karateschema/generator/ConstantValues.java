package com.tavo5691.util.karateschema.generator;

public final class ConstantValues {
	
	public final static class Key {
		public static final String KEY = "%s: ";
    }
	
	public final static class Value {
		public static final String MATCH_STRING = "'#string'";
		public static final String MATCH_PRESENT = "'#present'";
		public static final String MATCH_NUMBER = "'#number'";
		public static final String MATCH_BOOLEAN = "'#boolean'";
		public static final String MATCH_OBJECT_FORMAT = "'#(%s)'";
		public static final String MATCH_ARRAY_FORMAT = "'#[] (%s)'";
		public static final String MATCH_EMPTY_ARRAY = "[]";
		
		public static final String SCHEMA_FORMAT = "* def %s = %s";
    }

	public final static class Message {
		public static final String WARNING_MESSAGE = "WARNING: Value not supported for key: %s";
    }

	

}
