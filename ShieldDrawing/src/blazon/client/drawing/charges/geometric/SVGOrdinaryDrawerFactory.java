package blazon.client.drawing.charges.geometric;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.vectomatic.dom.svg.OMSVGDefsElement;

import blazon.shared.shield.Shield;
import blazon.shared.shield.charges.GeometricCharge;

public class SVGOrdinaryDrawerFactory {
	
	public List<SVGOrdinaryDrawer> createDrawers(Shield shield, OMSVGDefsElement defs, int shieldWidth, int shieldHeight) {
		List<SVGOrdinaryDrawer> ordinaryDrawers = new ArrayList<SVGOrdinaryDrawer>();
		if (shield == null) {
			return ordinaryDrawers;
		}
		List<GeometricCharge> charges = shield.getCharges();
		if (charges == null || charges.isEmpty()) {
			return ordinaryDrawers;
		}
		Iterator<GeometricCharge> iterator = charges.iterator();
		GeometricCharge currentCharge = iterator.next();
		boolean hasUnprocessedItems = true;
		int sameChargeCounter = 1;
		while (hasUnprocessedItems || iterator.hasNext()) {
			GeometricCharge nextCharge = null;
			if (iterator.hasNext()) {
				nextCharge = iterator.next();
			}
			if (currentCharge.equals(nextCharge)) {
				sameChargeCounter++;
				continue;
			}
			switch(currentCharge.getName()) {
			case BASE:
				ordinaryDrawers.add(new SVGBaseDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case BEND:
				ordinaryDrawers.add(new SVGBendDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case BENDLET:
				ordinaryDrawers.add(new SVGBendletDrawer(currentCharge, defs, shieldWidth, shieldHeight, sameChargeCounter));
				break;
			case BEND_SINISTER:
				ordinaryDrawers.add(new SVGBendSinisterDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case BENDLET_SINISTER:
				ordinaryDrawers.add(new SVGBendletSinisterDrawer(currentCharge, defs, shieldWidth, shieldHeight, sameChargeCounter));
				break;
			case BORDURE:
				ordinaryDrawers.add(new SVGBordureDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case CANTON:
				ordinaryDrawers.add(new SVGCantonDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case CHEVRON:
				ordinaryDrawers.add(new SVGChevronDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case CHEVRONEL:
				ordinaryDrawers.add(new SVGChevronelDrawer(currentCharge, defs, shieldWidth, shieldHeight, sameChargeCounter));
				break;
			case CHEVRON_REVERSED:
				ordinaryDrawers.add(new SVGChevronReversedDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case CHIEF:
				ordinaryDrawers.add(new SVGChiefDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case CROSS:
				ordinaryDrawers.add(new SVGCrossDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case FESS:
				ordinaryDrawers.add(new SVGFessDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case FLAUNCHES:
				ordinaryDrawers.add(new SVGFlaunchesDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case FRET:
				ordinaryDrawers.add(new SVGFretDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case GYRON:
				ordinaryDrawers.add(new SVGGyronDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case ORLE:
				ordinaryDrawers.add(new SVGOrleDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case PALE:
				ordinaryDrawers.add(new SVGPaleDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case PALL:
				ordinaryDrawers.add(new SVGPallDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case PALLET:
				ordinaryDrawers.add(new SVGPalletDrawer(currentCharge, defs, shieldWidth, shieldHeight, sameChargeCounter));
				break;
			case PALL_REVERSED:
				ordinaryDrawers.add(new SVGPallReversedDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case PILE:
				ordinaryDrawers.add(new SVGPileDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case PILE_REVERSED:
				ordinaryDrawers.add(new SVGPileReversedDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case QUARTER:
				ordinaryDrawers.add(new SVGQuarterDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case SALTIRE:
				ordinaryDrawers.add(new SVGSaltireDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case TRESSURE:
				ordinaryDrawers.add(new SVGTressureDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case BAR:
				ordinaryDrawers.add(new SVGBarDrawer(currentCharge, defs, shieldWidth, shieldHeight, sameChargeCounter));
				break;
			default:
				//return null;
				//TODO draw label of X
				
			}
			sameChargeCounter = 0;
			currentCharge = nextCharge;
			hasUnprocessedItems = false;
		}
		return ordinaryDrawers;
	}
}
