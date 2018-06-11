package com.codewar;

/**
 * @author ga.omar
 *
 *         <p>
 *         <strong> Short Intro</strong>
 *         </p>
 *         <p>
 *         Some of you might remember spending afternoons playing Street Fighter
 *         2 in some Arcade back in the 90s or emulating it nowadays with the
 *         numerous emulators for retro consoles.
 *         </p>
 *         <p>
 *         Can you solve this kata? Suuure-You-Can!
 *         </p>
 *         <p>
 *         UPDATE: a new kata's harder version is available <a href=
 *         "https://www.codewars.com/kata/street-fighter-2-character-selection-part-2/python"
 *         target="_blank">here</a>.
 *         </p>
 *         <p>
 *         <strong> The Kata </strong>
 *         </p>
 *         <p>
 *         You'll have to simulate the video game's character selection screen
 *         behaviour, more specifically the selection grid. Such screen looks
 *         like this:
 *         </p>
 *         <p>
 *         <img src=
 *         "https://images.duckduckgo.com/iu/?u=http%3A%2F%2Fwww.fightersgeneration.com%2Fnp5%2Fgm%2Fsf2ce-s2.jpg&amp;f=1"
 *         alt="alt text" title="Character Selection Screen for Street Fighter
 *         2">
 *         </p>
 *         <p>
 *         Selection Grid Layout in text:
 *         </p>
 * 
 *         <pre>
 * <code>| Ryu  | E.Honda | Blanka  | Guile   | Balrog | Vega    |
| Ken  | Chun Li | Zangief | Dhalsim | Sagat  | M.Bison |
</code>
 *         </pre>
 *         <p>
 *         <strong> Input </strong>
 *         </p>
 *         <ul>
 *         <li>the list of game characters in a 2x6 grid;</li>
 *         <li>the initial position of the selection cursor (top-left is
 *         <code>(0,0)</code>);</li>
 *         <li>a list of moves of the selection cursor (which are
 *         <code>up</code>, <code>down</code>, <code>left</code>,
 *         <code>right</code>);</li>
 *         </ul>
 *         <p>
 *         <strong> Output </strong>
 *         </p>
 *         <ul>
 *         <li>the list of characters who have been hovered by the selection
 *         cursor after all the moves (ordered and with repetition, all the ones
 *         after a move, wether successful or not, see tests);</li>
 *         </ul>
 *         <p>
 *         <strong> Rules </strong>
 *         </p>
 *         <p>
 *         Selection cursor is circular <em>horizontally</em> but <em>not
 *         vertically</em>!
 *         </p>
 *         <p>
 *         As you might remember from the game, the selection cursor rotates
 *         horizontally but not vertically; that means that if I'm in the
 *         leftmost and I try to go left again I'll get to the rightmost
 *         (examples: from Ryu to Vega, from Ken to M.Bison) and vice versa from
 *         rightmost to leftmost.
 *         </p>
 *         <p>
 *         Instead, if I try to go further up from the upmost or further down
 *         from the downmost, I'll just stay where I am located (examples: you
 *         can't go lower than lowest row: Ken, Chun Li, Zangief, Dhalsim, Sagat
 *         and M.Bison in the above image; you can't go upper than highest row:
 *         Ryu, E.Honda, Blanka, Guile, Balrog and Vega in the above image).
 *         </p>
 *         <p>
 *         <strong> Test </strong>
 *         </p>
 *         <p>
 *         For this easy version the fighters grid layout and the initial
 *         position will always be the same in all tests, only the list of moves
 *         change.
 *         </p>
 *         <p>
 *         <strong> Notice </strong>: changing some of the input data might not
 *         help you.
 *         </p>
 *         <p>
 *         <strong> Examples </strong>
 *         </p>
 *         <p>
 *         1.
 *         </p>
 * 
 *         <pre>
 * <code>fighters = [
    ["Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega"],
    ["Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison"]
]
initial_position = (0,0)
moves = ['up', 'left', 'right', 'left', 'left']
</code>
 *         </pre>
 *         <p>
 *         then I should get:
 *         </p>
 * 
 *         <pre>
 * <code>['Ryu', 'Vega', 'Ryu', 'Vega', 'Balrog']
</code>
 *         </pre>
 *         <p>
 *         as the characters I've been hovering with the selection cursor during
 *         my moves. Notice: Ryu is the first just because it "fails" the first
 *         <code>up</code> See test cases for more examples.
 *         </p>
 *         <p>
 *         2.
 *         </p>
 * 
 *         <pre>
 * <code>fighters = [
    ["Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega"],
    ["Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison"]
]
initial_position = (0,0)
moves = ['right', 'down', 'left', 'left', 'left', 'left', 'right']
</code>
 *         </pre>
 *         <p>
 *         Result:
 *         </p>
 * 
 *         <pre>
 * <code>['E.Honda', 'Chun Li', 'Ken', 'M.Bison', 'Sagat', 'Dhalsim', 'Sagat']
</code>
 *         </pre>
 * 
 * @see https://www.codewars.com/kata/5853213063adbd1b9b0000be
 * 
 */
public class StreetFighter {
	public static void main(String[] args) {

		String[][] fighters = { { "Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega" },
				{ "Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison" } };

		int[] initialPosition = { 0, 0 };

		String[] moves = { "right", "down", "left", "left", "left", "left", "right" };

		streetFighterSelection(fighters, initialPosition, moves);
	}

	public static String[] streetFighterSelection(String[][] fighters, int[] position, String[] moves) {
		String[] hoveredFighters = new String[moves.length];
		for (int i = 0; i < moves.length; i++) {
			hoveredFighters[i] = move(fighters, moves[i], position);
		}
		return hoveredFighters;
	}

	private static String move(String[][] fighters, String move, int[] position) {
		int[] nextPosition = position;
		if (move.equalsIgnoreCase("left")) {
			nextPosition[1]--;
			if (nextPosition[1] < 0)
				nextPosition[1] = 5;
		} else if (move.equalsIgnoreCase("right")) {
			nextPosition[1]++;
			if (nextPosition[1] > 5)
				nextPosition[1] = 0;
		} else if (move.equalsIgnoreCase("up")) {
			nextPosition[0] = 0;
		} else if (move.equalsIgnoreCase("down")) {
			nextPosition[0] = 1;
		}
		return fighters[nextPosition[0]][nextPosition[1]];
	}
}
