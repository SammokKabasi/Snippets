package com.synacor.squirrel;

class Squirrel {

	enum TAIL {
		LONG, SHORT, BUSHY
	};

	enum EARS {
		POINTED, ROUNDED
	};

	enum GENDER {
		MALE, FEMALE
	};

	TAIL tail;
	GENDER gender;
	EARS ears;

	public Squirrel(TAIL tail, EARS ears, GENDER gender) {
		this.tail = tail;
		this.ears = ears;
		this.gender = gender;
	}
}
