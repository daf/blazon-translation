package blazon.client.drawing.charges.geometric;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.vectomatic.dom.svg.OMSVGDefsElement;

import blazon.client.drawing.charges.geometric.mobile.SVGAnnuletDrawer;
import blazon.client.drawing.charges.geometric.mobile.SVGBilletDrawer;
import blazon.client.drawing.charges.geometric.mobile.SVGEscutcheonDrawer;
import blazon.client.drawing.charges.geometric.mobile.SVGFusilDrawer;
import blazon.client.drawing.charges.geometric.mobile.SVGLozengeDrawer;
import blazon.client.drawing.charges.geometric.mobile.SVGMascleDrawer;
import blazon.client.drawing.charges.geometric.mobile.SVGMulletDrawer;
import blazon.client.drawing.charges.geometric.mobile.SVGRoundelDrawer;
import blazon.client.drawing.charges.geometric.mobile.SVGRustreDrawer;
import blazon.client.drawing.charges.geometric.mobile.SVGStarDrawer;
import blazon.shared.shield.Shield;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;

public class SVGChargeDrawerFactory {
	
	public List<SVGOrdinaryDrawer> createDrawers(Shield shield, OMSVGDefsElement defs, int shieldWidth, int shieldHeight) {
		List<SVGOrdinaryDrawer> chargeDrawers = new ArrayList<SVGOrdinaryDrawer>();
		if (shield == null) {
			return chargeDrawers;
		}
		List<GeometricCharge> charges = shield.getCharges();
		if (charges == null || charges.isEmpty()) {
			return chargeDrawers;
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
			List<ShieldDiagnostic> diags = shield.getShieldDiagnostics();
			switch(currentCharge.getName()) {
			case BASE:
				chargeDrawers.add(new SVGBaseDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight));
				break;
			case BEND:
				chargeDrawers.add(new SVGBendDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight));
				break;
			case BENDLET:
				chargeDrawers.add(new SVGBendletDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight, sameChargeCounter));
				break;
			case BEND_SINISTER:
				chargeDrawers.add(new SVGBendSinisterDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight));
				break;
			case BENDLET_SINISTER:
				chargeDrawers.add(new SVGBendletSinisterDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight, sameChargeCounter));
				break;
			case BORDURE:
				chargeDrawers.add(new SVGBordureDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight));
				break;
			case CANTON:
				chargeDrawers.add(new SVGCantonDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight));
				break;
			case CHEVRON:
				chargeDrawers.add(new SVGChevronDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight));
				break;
			case CHEVRONEL:
				chargeDrawers.add(new SVGChevronelDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight, sameChargeCounter));
				break;
			case CHEVRON_REVERSED:
				chargeDrawers.add(new SVGChevronReversedDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight));
				break;
			case CHIEF:
				chargeDrawers.add(new SVGChiefDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight));
				break;
			case CROSS:
				chargeDrawers.add(new SVGCrossDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight));
				break;
			case FESS:
				chargeDrawers.add(new SVGFessDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight));
				break;
			case FLAUNCHES:
				chargeDrawers.add(new SVGFlaunchesDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight));
				break;
			case FRET:
				chargeDrawers.add(new SVGFretDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight));
				break;
			case GYRON:
				chargeDrawers.add(new SVGGyronDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight));
				break;
			case ORLE:
				chargeDrawers.add(new SVGOrleDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight));
				break;
			case PALE:
				chargeDrawers.add(new SVGPaleDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight));
				break;
			case PALL:
				chargeDrawers.add(new SVGPallDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight));
				break;
			case PALLET:
				chargeDrawers.add(new SVGPalletDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight, sameChargeCounter));
				break;
			case PALL_REVERSED:
				chargeDrawers.add(new SVGPallReversedDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight));
				break;
			case PILE:
				chargeDrawers.add(new SVGPileDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight));
				break;
			case PILE_REVERSED:
				chargeDrawers.add(new SVGPileReversedDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight));
				break;
			case QUARTER:
				chargeDrawers.add(new SVGQuarterDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight));
				break;
			case SALTIRE:
				chargeDrawers.add(new SVGSaltireDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight));
				break;
			case TRESSURE:
				chargeDrawers.add(new SVGTressureDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight));
				break;
			case BAR:
				chargeDrawers.add(new SVGBarDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight, sameChargeCounter));
				break;
			case ANNULET:
				chargeDrawers.add(new SVGAnnuletDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight, sameChargeCounter));
				break;
			case BILLET:
				chargeDrawers.add(new SVGBilletDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight, sameChargeCounter));
				break;
			case ESCUTCHEON:
				chargeDrawers.add(new SVGEscutcheonDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight, sameChargeCounter));
				break;
			case FUSIL:
				chargeDrawers.add(new SVGFusilDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight, sameChargeCounter));
				break;
			case LOZENGE:
				chargeDrawers.add(new SVGLozengeDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight, sameChargeCounter));
				break;
			case MASCLE:
				chargeDrawers.add(new SVGMascleDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight, sameChargeCounter));
				break;
			case MULLET:
				chargeDrawers.add(new SVGMulletDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight, sameChargeCounter));
				break;
			case ROUNDEL:
				chargeDrawers.add(new SVGRoundelDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight, sameChargeCounter));
				break;
			case RUSTRE:
				chargeDrawers.add(new SVGRustreDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight, sameChargeCounter));
				break;
			case STAR:
				chargeDrawers.add(new SVGStarDrawer(currentCharge, defs, diags, shieldWidth, shieldHeight, sameChargeCounter));
				break;
			default:
				//return null;
				//TODO draw label of X
				
			}
			sameChargeCounter = 0;
			currentCharge = nextCharge;
			hasUnprocessedItems = false;
		}
		return chargeDrawers;
	}
}
