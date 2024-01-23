/*----------------------------------------------------------
	FILE			: Triple.java
	AUTHOR			: Java-Nov-2022 Group
	LAST UPDATE		: 29.07.2023

	Triple class that represents a triple tuple

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
------------------------------------------------------------*/
package org.csystem.collection.tuple;

public class Triple<F, S, T> {
    public final F first;
    public final S second;

    public final T third;

    public static <F, S, T> Triple<F, S, T> of(F first, S second, T third)
    {
        return new Triple<>(first, second, third);
    }

    public Triple(F first, S second, T third)
    {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public boolean equals(Object other)
    {
        return other instanceof Triple<?, ?, ?> triple
                && first.equals(triple.first) && second.equals(triple.second) && third.equals(triple.third);
    }

    public String toString()
    {
        return String.format("(%s, %s, %s)", first, second, third);
    }
    //...
}
