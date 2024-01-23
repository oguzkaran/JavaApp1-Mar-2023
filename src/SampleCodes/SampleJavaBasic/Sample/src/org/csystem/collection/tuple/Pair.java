/*----------------------------------------------------------
	FILE			: Pair.java
	AUTHOR			: Java-Nov-2022 Group
	LAST UPDATE		: 29.07.2023

	Pair class that represents a pair tuple

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
------------------------------------------------------------*/
package org.csystem.collection.tuple;

public class Pair<F, S> {
    public final F first;
    public final S second;

    public static <F, S> Pair<F, S> of(F first, S second)
    {
        return new Pair<>(first, second);
    }

    public Pair(F first, S second)
    {
        this.first = first;
        this.second = second;
    }

    public boolean equals(Object other)
    {
        return other instanceof Pair<?, ?> pair && first.equals(pair.first) && second.equals(pair.second);
    }

    public String toString()
    {
        return String.format("(%s, %s)", first, second);
    }

    //...
}
