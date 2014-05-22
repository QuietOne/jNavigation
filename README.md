#jNavigation

Navigation for jMonkey Engine. It will be port for Recast Navigation by Mikko Mononen memon@inside.org. You can find original source code at https://github.com/memononen/recastnavigation .

##Description
Members in this module are used to create mesh data that is then used to create Detour navigation meshes.

The are a large number of possible ways to building navigation mesh data. One of the simple piplines is as follows:
<ol>
<li>Prepare the input triangle mesh.</li>
<li>Build a Heightfield.</li>
<li>Build a CompactHeightfield.</li>
<li>Build a ContourSet.</li>
<li>Build a PolyMesh.</li>
<li>Build a PolyMeshDetail.</li>
<li>Use the PolyMesh and PolyMeshDetail to build a Detour navigation mesh tile.</li>
</ol>
The general life-cycle of the main classes is as follows:
<ol>
<li>Allocate the object using the Recast allocator. (E.g. allocHeightfield) (It will be implicit)</li>
<li>Initialize or build the object. (E.g. createHeightfield)</li>
<li>Update the object as needed. (E.g. rasterizeTriangles)</li>
<li>Use the object as part of the pipeline.</li>
<li>Free the object using the Recast allocator. (E.g. freeHeightField) (It will be implicit)</li>
</ol>

###Note
This is a summary list of members. Use the index or search feature to find minor members.