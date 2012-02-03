package blazon.client.drawing.charges.geometric;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.vectomatic.dom.svg.OMSVGDefsElement;

import blazon.client.drawing.charges.advanced.SVGAdvancedChargeDrawer;
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
import blazon.shared.shield.charges.AdvancedCharge;
import blazon.shared.shield.charges.Charge;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;

public class SVGChargeDrawerFactory {
	
	public List<SVGChargeDrawer> createDrawers(Shield shield, OMSVGDefsElement defs, int shieldWidth, int shieldHeight) {
		List<SVGChargeDrawer> chargeDrawers = new ArrayList<SVGChargeDrawer>();
		if (shield == null) {
			return chargeDrawers;
		}
		List<Charge> charges = shield.getCharges();
		if (charges == null || charges.isEmpty()) {
			return chargeDrawers;
		}
		Iterator<Charge> iterator = charges.iterator();
		Charge currentCharge = iterator.next();
		boolean hasUnprocessedItems = true;
		int sameChargeCounter = 1;
		while (hasUnprocessedItems || iterator.hasNext()) {
			GeometricCharge nextCharge = null;
			if (iterator.hasNext()) {
				nextCharge = (GeometricCharge) iterator.next();
			}
			if (currentCharge.equals(nextCharge)) {
				sameChargeCounter++;
				continue;
			}
			if (currentCharge instanceof GeometricCharge) {
				GeometricCharge currentGeometricCharge = (GeometricCharge) currentCharge;
				List<ShieldDiagnostic> diags = shield.getShieldDiagnostics();
				switch(currentGeometricCharge.getName()) {
				case BASE:
					chargeDrawers.add(new SVGBaseDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight));
					break;
				case BEND:
					chargeDrawers.add(new SVGBendDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight));
					break;
				case BENDLET:
					chargeDrawers.add(new SVGBendletDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight, sameChargeCounter));
					break;
				case BEND_SINISTER:
					chargeDrawers.add(new SVGBendSinisterDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight));
					break;
				case BENDLET_SINISTER:
					chargeDrawers.add(new SVGBendletSinisterDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight, sameChargeCounter));
					break;
				case BORDURE:
					chargeDrawers.add(new SVGBordureDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight));
					break;
				case CANTON:
					chargeDrawers.add(new SVGCantonDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight));
					break;
				case CHEVRON:
					chargeDrawers.add(new SVGChevronDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight));
					break;
				case CHEVRONEL:
					chargeDrawers.add(new SVGChevronelDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight, sameChargeCounter));
					break;
				case CHEVRON_REVERSED:
					chargeDrawers.add(new SVGChevronReversedDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight));
					break;
				case CHIEF:
					chargeDrawers.add(new SVGChiefDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight));
					break;
				case CROSS:
					chargeDrawers.add(new SVGCrossDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight));
					break;
				case FESS:
					chargeDrawers.add(new SVGFessDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight));
					break;
				case FLAUNCHES:
					chargeDrawers.add(new SVGFlaunchesDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight));
					break;
				case FRET:
					chargeDrawers.add(new SVGFretDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight));
					break;
				case GYRON:
					chargeDrawers.add(new SVGGyronDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight));
					break;
				case ORLE:
					chargeDrawers.add(new SVGOrleDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight));
					break;
				case PALE:
					chargeDrawers.add(new SVGPaleDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight));
					break;
				case PALL:
					chargeDrawers.add(new SVGPallDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight));
					break;
				case PALLET:
					chargeDrawers.add(new SVGPalletDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight, sameChargeCounter));
					break;
				case PALL_REVERSED:
					chargeDrawers.add(new SVGPallReversedDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight));
					break;
				case PILE:
					chargeDrawers.add(new SVGPileDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight));
					break;
				case PILE_REVERSED:
					chargeDrawers.add(new SVGPileReversedDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight));
					break;
				case QUARTER:
					chargeDrawers.add(new SVGQuarterDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight));
					break;
				case SALTIRE:
					chargeDrawers.add(new SVGSaltireDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight));
					break;
				case TRESSURE:
					chargeDrawers.add(new SVGTressureDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight));
					break;
				case BAR:
					chargeDrawers.add(new SVGBarDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight, sameChargeCounter));
					break;
				case ANNULET:
					chargeDrawers.add(new SVGAnnuletDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight, sameChargeCounter));
					break;
				case BILLET:
					chargeDrawers.add(new SVGBilletDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight, sameChargeCounter));
					break;
				case ESCUTCHEON:
					chargeDrawers.add(new SVGEscutcheonDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight, sameChargeCounter));
					break;
				case FUSIL:
					chargeDrawers.add(new SVGFusilDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight, sameChargeCounter));
					break;
				case LOZENGE:
					chargeDrawers.add(new SVGLozengeDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight, sameChargeCounter));
					break;
				case MASCLE:
					chargeDrawers.add(new SVGMascleDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight, sameChargeCounter));
					break;
				case MULLET:
					chargeDrawers.add(new SVGMulletDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight, sameChargeCounter));
					break;
				case ROUNDEL:
					chargeDrawers.add(new SVGRoundelDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight, sameChargeCounter));
					break;
				case RUSTRE:
					chargeDrawers.add(new SVGRustreDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight, sameChargeCounter));
					break;
				case STAR:
					chargeDrawers.add(new SVGStarDrawer(currentGeometricCharge, defs, diags, shieldWidth, shieldHeight, sameChargeCounter));
					break;
				default:
					//return null;
					//TODO draw label of X
					
				}
			} else if (currentCharge instanceof AdvancedCharge) {
				chargeDrawers.add(new SVGAdvancedChargeDrawer((AdvancedCharge) currentCharge, defs, shield.getShieldDiagnostics(), shieldWidth, shieldHeight));
			}
			sameChargeCounter = 0;
			currentCharge = nextCharge;
			hasUnprocessedItems = false;
		}
		return chargeDrawers;
	}
}
