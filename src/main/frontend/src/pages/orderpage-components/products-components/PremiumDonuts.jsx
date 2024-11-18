import blueberryCheese from "./assets/premiums/blueberry_cheese.png";
import bostonCoffeeKreme from "./assets/premiums/boston_coffee_kreme.png";
import chocoButternut from "./assets/premiums/choco_butternut.png";
import chocoTrickles from "./assets/premiums/choco_trickles.png";
import choconutSundae from "./assets/premiums/choconut_sundae.png";
import cinnamonSugarDusted from "./assets/premiums/cinnamon_sugar_dusted.png";
import cookiesNCream from "./assets/premiums/cookies_and_cream.png";
import darkChoco from "./assets/premiums/dark_choco.png";
import rockyRoad from "./assets/premiums/rocky_road.png";
import strawberryKremeFilled from "./assets/premiums/strawberry_kreme_filled.png";

import Item from "../../admin-components/product-components/Item";
import "./productTypes.css";

export default function PremiumDonuts({ handleItemClick }) {
  const price = 55;
  return (
    <div className="prodContainer">
      <Item
        name={"Blueberry Cheese"}
        img={blueberryCheese}
        price={price}
        handleItemClick={handleItemClick}
        type={"Premium"}
      />
      <Item
        name={"Boston Coffee Kreme"}
        img={bostonCoffeeKreme}
        price={price}
        handleItemClick={handleItemClick}
        type={"Premium"}
      />
      <Item
        name={"Choco Butternut"}
        img={chocoButternut}
        price={price}
        handleItemClick={handleItemClick}
        type={"Premium"}
      />
      <Item
        name={"Choco Trickles"}
        img={chocoTrickles}
        price={price}
        handleItemClick={handleItemClick}
        type={"Premium"}
      />
      <Item
        name={"Choconut Sundae"}
        img={choconutSundae}
        price={price}
        handleItemClick={handleItemClick}
        type={"Premium"}
      />
      <Item
        name={"Cinnamon Sugar Dusted"}
        img={cinnamonSugarDusted}
        price={price}
        handleItemClick={handleItemClick}
        type={"Premium"}
      />
      <Item
        name={"Cookies and Cream"}
        img={cookiesNCream}
        price={price}
        handleItemClick={handleItemClick}
        type={"Premium"}
      />
      <Item
        name={"Dark Choco"}
        img={darkChoco}
        price={price}
        handleItemClick={handleItemClick}
        type={"Premium"}
      />
      <Item
        name={"Rocky Road"}
        img={rockyRoad}
        price={price}
        handleItemClick={handleItemClick}
        type={"Premium"}
      />
      <Item
        name={"Strawberry Kreme Filled"}
        img={strawberryKremeFilled}
        price={price}
        handleItemClick={handleItemClick}
        type={"Premium"}
      />
    </div>
  );
}
