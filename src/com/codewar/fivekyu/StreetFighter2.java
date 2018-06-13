package com.codewar.fivekyu;

/**
 * @author ga.omar
 * 
 *         <p>
 *         This is the rightful continuation to this easier Kata
 *         {@link com.codewar.StreetFighter} and some rules are the same with
 *         few substantial alterations.
 *         </p>
 *         <p>
 *         This time we have to deal with a situation like Super Street Fighter
 *         2 Selection Screen:
 *         </p>
 *         <p>
 *         <img src=
 *         "https://images.duckduckgo.com/iu/?u=http%3A%2F%2Fwww.vizzed.com%2Fvizzedboard%2Fretro%2Fuser_screenshots%2Fsaves40%2F409292%2FGENESIS--Super%2520Street%2520Fighter%2520II%2520%2520The%2520New%2520Challengers_Jul2%252019_26_37.png&amp;f=1"
 *         alt="alt text" title="Super Street Fighter 2 Character Selection">
 *         </p>
 *         <p>
 *         As you may see, we now have 16 characters on 3 rows. You might think:
 *         let's make an array of 3 arrays! But that's not enough.
 *         </p>
 *         <p>
 *         <strong> EMPTY SPACE </strong>
 *         </p>
 *         <p>
 *         The first character of the first row (Ryu) is not aligned with the
 *         first of the second row (Balrog) but with the second (Ken) and the
 *         same goes with the other side; therefore we need to introduce
 *         something new, like an offset: the <strong>Empty Space</strong>.
 *         </p>
 *         <p>
 *         The empty space, represented as empty string <code>""</code>, will
 *         allow us to keep the grid aligned and rectangular, with spaces that
 *         won't be selectable. In this case we need 2 empty spaces (3 rows x 6
 *         columns = 18 slots, 18 slots - 16 characters = 2 empty spaces). Like
 *         this:
 *         </p>
 * 
 *         <pre>
 * <code>|        | Ryu    | E.Honda  | Blanka  | Guile   |         |
 | Balrog | Ken    | Chun Li  | Zangief | Dhalsim | Sagat   |
 | Vega   | T.Hawk | Fei Long | Deejay  | Cammy   | M.Bison |
</code>
 *         </pre>
 *         <p>
 *         The moves of the selection cursor are the same as before: rotate
 *         horizontally but stop vertically. When you find empty spaces (1 or
 *         more) you need to skip them if you approach them horizontally and get
 *         to the next selectable slot with the next fighter on the left or
 *         right; and if you approach them vertically you need to just stop and
 *         stay where you are.
 *         </p>
 *         <p>
 *         Example: if you are on Ryu and move left, you must get to Guile; if
 *         you are on Balrog and move up, you must stay on Balrog.
 *         </p>
 *         <p>
 *         Notice: I might put empty spaces <em>right in the middle</em> and the
 *         rectangular grids can be any size, not only 3x6, deal with this too.
 *         </p>
 *         <p>
 *         <strong> WHAT'S NEW </strong>
 *         </p>
 *         <p>
 *         So, let's resume what are the <strong>new issues</strong> in this
 *         harder version of the Kata:
 *         </p>
 *         <ul>
 *         <li>The initial position might be any non-empty slot in the grid
 *         (given as input).</li>
 *         <li>The characters grid (also given as input) might have any
 *         rectangular layout, not only 3 rows.</li>
 *         <li>The grid might contain empty spaces, both on the borders or right
 *         in the middle.</li>
 *         </ul>
 *         <p>
 *         <strong> INPUT </strong>
 *         </p>
 *         <ul>
 *         <li>Fighters grid;</li>
 *         <li>Initial position;</li>
 *         <li>List of moves.</li>
 *         </ul>
 *         <p>
 *         The third input parameter is still the list of moves (all valid ones:
 *         left, right, up or down).
 *         </p>
 *         <p>
 *         <strong> OUTPUT </strong>
 *         </p>
 *         <p>
 *         The output is the same as before: the list of characters that have
 *         been hovered by the selection cursor after each move, successful or
 *         not.
 *         </p>
 *         <p>
 *         Hopefully test cases will complete my explanation.
 *         </p>
 * 
 * @see https://www.codewars.com/kata/street-fighter-2-character-selection-part-2
 *
 */
public class StreetFighter2 {

	static int horizontal = 0;
	static int vertical = 0;

	public static void main(String[] args) {

		String[][] fighters = { { "", "Ryu", "E.Honda", "Blanka", "Guile", "" },
				{ "Balrog", "Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat" },
				{ "Vega", "T.Hawk", "Fei Long", "Deejay", "Cammy", "M.Bison " } };

		String[] moves = new String[] { "down", "right", "right", "right", "down", "left", "left", "down", "right",
				"right", "right", "up" };

		int[] initialPosition = new int[] { 0, 3 };

		superStreetFighterize(fighters, initialPosition, moves);
	}

	public static String[] superStreetFighterize(String[][] fighters, int[] position, String[] moves) {
		horizontal = fighters[0].length - 1;
		vertical = fighters.length - 1;
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
				nextPosition[1] = horizontal;
		} else if (move.equalsIgnoreCase("right")) {
			nextPosition[1]++;
			if (nextPosition[1] > horizontal)
				nextPosition[1] = 0;
		} else if (move.equalsIgnoreCase("up")) {
			nextPosition[0]--;
			if (nextPosition[0] < 0)
				nextPosition[0] = 0;
			if (fighters[nextPosition[0]][nextPosition[1]].equals("")) {

				// logic for skipping if the empty box is in between the board
				// if(nextPosition[0] == 0)
				// nextPosition[0]++;
				// else
				// nextPosition[0]--;
				nextPosition[0]++;
			}
		} else if (move.equalsIgnoreCase("down")) {
			nextPosition[0]++;
			if (nextPosition[0] > vertical)
				nextPosition[0] = vertical;
			if (fighters[nextPosition[0]][nextPosition[1]].equals("")) {

				// logic for skipping if the empty box is in between the board
				// if(nextPosition[0] == vertical)
				// nextPosition[0]--;
				// else
				// nextPosition[0]++;
				nextPosition[0]--;
			}
		}
		if (fighters[nextPosition[0]][nextPosition[1]].equals(""))
			move(fighters, move, nextPosition);

		return fighters[nextPosition[0]][nextPosition[1]];
	}
}
