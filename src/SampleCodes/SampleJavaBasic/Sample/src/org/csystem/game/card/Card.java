package org.csystem.game.card;

public class Card {
   private CardValue m_value;
   private CardType m_type;

   private static void fillDeck(Card [] deck)
   {
      int idx = 0;

      for (CardType cardType : CardType.values())
         for (CardValue cardValue : CardValue.values())
            deck[idx++] = new Card(cardValue, cardType);
   }

   private static void swap(Card [] deck, int i, int k)
   {
      Card temp = deck[i];

      deck[i] = deck[k];
      deck[k] = temp;
   }

   public static Card[] getShuffledDeck()
   {
      Card[] deck = new Card[52];

      fillDeck(deck);
      //...
      return deck;
   }

   public Card(CardValue value, CardType type)
   {
      m_value = value;
      m_type = type;
   }

   public Card(String name)
   {
      throw new UnsupportedOperationException("TODO:");
   }

   public String getName()
   {
      throw new UnsupportedOperationException("TODO: Kupa-Papaz");
   }

   public void setName(String name)
   {
      throw new UnsupportedOperationException("TODO:Kupa-Papaz");
   }

   public boolean equals(Object other)
   {
      return other instanceof Card c && m_type == c.m_type && m_value == c.m_value;
   }

   public String toString()
   {
      return String.format("%s-%s", m_type.toString(), m_value.toString());
   }
}
